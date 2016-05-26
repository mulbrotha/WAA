/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mulu.cs545.WAA.Day3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mulu
 */
@WebServlet(name = "Myservlet", urlPatterns = {"/ServletController"})
public class Myservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    List<Student> StudentList = new ArrayList<Student>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Myservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Myservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //  processRequest(request, response);

        RequestDispatcher view;
        Student std;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String findbtn = request.getParameter("findbtn");
            String noSearchbtn = request.getParameter("cancelSearch");
            String deletebtn = request.getParameter("deleteStudent");
            String deletecancel = request.getParameter("canceldelete");
            if ("Find".equals(findbtn)) {// search
                 std = findStudent(id);
                request.setAttribute("std", std);
                request.getSession().setAttribute("studentfound", std);
                request.getSession().setAttribute("studentDeleteID", std.getsID());
                
                view = request.getRequestDispatcher("SearchResult.jsp");
                view.forward(request, response);

            } else if ("cancel".equals(noSearchbtn)) {// don't search
                view = request.getRequestDispatcher("Home.jsp");
                view.forward(request, response);
            } else if ("Delete".equals(deletebtn)) {//delete button clicked
                 int stdid = Integer.parseInt(request.getSession().getAttribute("studentDeleteID").toString());
                Student stdDelete ;//= (Student) request.getSession().getAttribute("studentfound");
                stdDelete=findStudent(stdid);
                if (stdDelete != null) {
                    StudentList.remove(stdDelete);
                    request.getServletContext().setAttribute("Student", StudentList);
                    view = request.getRequestDispatcher("Home.jsp");
                    view.forward(request, response);
                }
            } else {//don't delete
                view = request.getRequestDispatcher("Home.jsp");
                view.forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            view = request.getRequestDispatcher("error.jsp");
            view.forward(request, response);
        }

    }

    Student findStudent(int id) {
        Student searchStudent = null;
        for (Student s : StudentList) {
            if (s.getsID() == id) {
                searchStudent = s;
                break;
            }

        }
        return searchStudent;
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
        // processRequest(request, response);
        dothing(request, response);

    }

    private void dothing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double gpa = Double.parseDouble(request.getParameter("gpa"));
            String gender = request.getParameter("gender");

            String addbtn = request.getParameter("addUser");
            String cancelbtn = request.getParameter("cancel");

            // List<Student> StudentList= new ArrayList<Student>();
            Student student = new Student(id, name, gpa, gender);
            StudentList.add(student);
            request.getServletContext().setAttribute("Student", StudentList);
            if ("Add".equals(addbtn)) {

                view = request.getRequestDispatcher("DetailInfo.jsp");
                view.forward(request, response);
            } else {
                view = request.getRequestDispatcher("Home.jsp");
                view.forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            view = request.getRequestDispatcher("error.jsp");
            view.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
