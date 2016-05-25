/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author csfaculty
 */
public class Server {
    
    private int port = 8181;
    private int backlog= 5;
    private String bindingAddress = "127.0.0.1";
    
    public void startup() {
        try {
            ServerSocket serverSocket = new ServerSocket(port, backlog, InetAddress.getByName(bindingAddress));
            System.out.println("Ready");
            Socket socket = serverSocket.accept();
            System.out.println("Accepted");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream)); 
            
            String requestpage=br.readLine();
            System.out.println(requestpage);
            int characterRead = 0;
            while (inputStream.available() != 0) {
                characterRead= inputStream.read();
                System.out.print((char) characterRead);
            }
             String page1="page1.html";
             String page2="page2.html";
             String page="page.html";
            if(requestpage.equalsIgnoreCase(page1)&& requestpage!=null){
             byte[] bytes=page1.getBytes();
             outputStream.write(bytes);
            }
            else if(requestpage.equalsIgnoreCase(page2)){
                outputStream.write("23".getBytes());
            }
            else if(requestpage.equalsIgnoreCase(page)){
                outputStream.write("301".getBytes());
            }
            else{
               outputStream.write("404".getBytes());
            }
            socket.close();
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
