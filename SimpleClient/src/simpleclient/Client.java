/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author csfaculty
 */
public class Client {
    private String host = "127.0.0.1";
    private int port = 8181;
    boolean autoFlush = true;
    String defaultPage = "index.html";
    
    public void start() {
        Socket socket = makeRequest();
        System.out.println("Socket created");
        renderRespose(socket);
    }
    
    public Socket makeRequest() {
        Socket socket= null;
        try {
            socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), autoFlush);
            out.println(defaultPage);
            out.println("Host: "+host+":"+port);
            out.println("Connection: Close");
            out.println("");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return socket;
    }
    
    public void renderRespose(Socket socket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuffer sb = new StringBuffer(8096);
            boolean loop= true;
            while (loop) {
                if (in.ready()) {
                    int i= 0;
                    while (i!=-1) {
                        i= in.read();
                        sb.append((char)i);
                    }
                    loop= false;
                }
            }
            System.out.println(sb);
            Thread.sleep(5000);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
