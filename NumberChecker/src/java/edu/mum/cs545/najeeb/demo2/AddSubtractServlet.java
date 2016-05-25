/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.najeeb.demo2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author csfaculty
 */
public class AddSubtractServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Add Subtract</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add Subtract at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD>");
        out.print("</HEAD>");
        out.print("<BODY>");
        out.print("<H1>");
         String number1 = request.getParameter("num1");
         String number2 = request.getParameter("num2");
         try{
        int int_number1 = Integer.parseInt(number1);
        int int_number2 = Integer.parseInt(number2);
         
        String addbtn=request.getParameter("AddBtn");
        String subbtn=request.getParameter("SubBtn");  
         int sum;
//         out.print(addbtn);
//         out.print(subbtn);
            if((int_number1<=0||int_number1>=100)||(int_number2<=0||int_number2>=100)){
                    out.print("Enter a number between 0 and 100");
                }
               
            
        if ("Add".equals(addbtn)) {
            //add the two numbers
            sum=int_number1+int_number2;
        }else{
            //subtruct
            sum=int_number1-int_number2;
        }
        out.print(sum);
        out.print("</H1>");
        out.print("<FORM action=\"index.jsp\">");
        out.print("<INPUT type=\"submit\" value=\"Back\" />");
        out.print("</FORM>");
        out.print("</BODY>");
        out.print("</HTML>");
        }
        catch(NumberFormatException e){
            out.print("invalid input: "+e.getMessage());
        }
//        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
