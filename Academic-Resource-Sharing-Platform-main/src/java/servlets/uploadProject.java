/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sachi
 */
public class uploadProject extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            // Empty block, no need for this as processRequest isn't doing anything
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
        processRequest(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String pName = request.getParameter("pname");
            String pDescription = request.getParameter("description");
            String pAuthor = request.getParameter("author");
            String pRepo = request.getParameter("repolink");

            // Debugging information
            System.out.println(pName + " " + pDescription + " " + pAuthor + " " + pRepo);

            try (Connection con = DbConnect.getConn()) {
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO project (P_name, P_description, P_author, P_repo) VALUES (?, ?, ?, ?)");
                ps.setString(1, pName);
                ps.setString(2, pDescription);
                ps.setString(3, pAuthor);
                ps.setString(4, pRepo);

                int i = ps.executeUpdate();
                if (i == 1) {
                    out.write("<script>alert('Upload Successful'); window.location.href='projects.jsp';</script>");
                } else {
                    out.write("<script>alert('Error in Server'); window.location.href='projects.jsp';</script>");
                }
            } catch (Exception e) {
                System.out.println(e);
                out.write("<script>alert('Try Changing Project Name'); window.location.href='projects.jsp';</script>");
            }
        }
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
