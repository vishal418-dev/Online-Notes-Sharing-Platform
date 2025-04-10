/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.sql.*;



/**
 *
 * @author 91741
 */
@MultipartConfig
public class uploadFile extends HttpServlet {

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
    processRequest(request, response);
    try (PrintWriter out = response.getWriter()) {
        Part p = request.getPart("file");
        String fileName = p.getSubmittedFileName();
        String topic = request.getParameter("topic");
        String author = request.getParameter("author");
        String subject = request.getParameter("subject");
         String imageFilename = p.getSubmittedFileName();
        String upload =  "E:/notes-sharing/build/web/notes/"+ imageFilename;
        try {
             Connection con=DbConnect.getConn();
              PreparedStatement ps = con.prepareStatement("insert into files (subject,filename,topic,author,fileLoc) values(?,?,?,?,?)");
            ps.setString(1, subject);
            ps.setString(2, fileName);
            ps.setString(3, topic);
            ps.setString(4, author);
            ps.setString(5, upload);
            int i = ps.executeUpdate();
            if (i == 1) {             
        
        
        
        
        FileOutputStream fos = new FileOutputStream(upload);
        InputStream is = p.getInputStream();
        
        byte[] data = new byte[is.available()];
        is.read(data);
        fos.write(data);
        fos.close();
        System.out.print(upload);

                out.println("<script>alert('Upload Successful'); window.location.href='upload.html';</script>");
            } else {
                out.write("Error in Server");
            }
        } catch (Exception e) {
            System.out.println(e);
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
