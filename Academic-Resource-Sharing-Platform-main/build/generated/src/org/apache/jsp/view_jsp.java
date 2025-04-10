package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.io.*;
import java.sql.*;
import servlets.*;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <script>\n");
      out.write("        function redirectTo(fileLoc) {\n");
      out.write("            // Redirect to the fileLoc\n");
      out.write("            window.location.href = fileLoc;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Best Engineering Notes</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\"> <!-- Assuming you have a separate CSS file -->\n");
      out.write("    <style>\n");
      out.write("        /* Center content in the body */\n");
      out.write("        body {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            height: 100vh;\n");
      out.write("            margin: 0;\n");
      out.write("            background: radial-gradient(#1e879f, #325dc1);\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Center content in the form-container */\n");
      out.write("        .form-container {\n");
      out.write("            text-align: center;\n");
      out.write("            background: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Style the table */\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin: 20px 0;\n");
      out.write("            font-size: 18px;\n");
      out.write("            text-align: left;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th, td {\n");
      out.write("            padding: 12px;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th {\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Style for select optgroup */\n");
      out.write("        select optgroup {\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: #333;\n");
      out.write("            font-size: 16px;\n");
      out.write("            padding: 8px 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        select optgroup option {\n");
      out.write("            padding-left: 20px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"form-container\">\n");
      out.write("        <h2>Select Branch, Semester, and Upload File</h2>\n");
      out.write("\n");
      out.write("        <!-- Form with select, file input, and submit button -->\n");
      out.write("        <form action=\"");
      out.print( request.getContextPath() );
      out.write("/view.jsp\" method=\"post\">\n");
      out.write("            <select name=\"subject\" id=\"subjectSelect\">\n");
      out.write("                <optgroup label=\"CSE\">\n");
      out.write("                    <optgroup label=\"1st Sem\">\n");
      out.write("                        <option value=\"data-structures\">Data Structures</option>\n");
      out.write("                        <option value=\"programming-fundamentals\">Programming Fundamentals</option>\n");
      out.write("                        <option value=\"digital-logic\">Digital Logic</option>\n");
      out.write("                    </optgroup>\n");
      out.write("                    <optgroup label=\"2nd Sem\">\n");
      out.write("                        <option value=\"algorithms\">Algorithms</option>\n");
      out.write("                        <option value=\"database-management\">Database Management</option>\n");
      out.write("                        <option value=\"computer-networks\">Computer Networks</option>\n");
      out.write("                    </optgroup>\n");
      out.write("                    <!-- Add more semesters and subjects as needed -->\n");
      out.write("                </optgroup>\n");
      out.write("                <!-- Add other branches like ME, EEE, CE, EE here -->\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Submit\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <!-- Display fetched notes here -->\n");
      out.write("        ");

            // Process form submission
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                // Retrieve form parameters
                String subject = request.getParameter("subject");

                // Fetch notes from the database based on selected criteria
                try {
                    Connection con = DbConnect.getConn();
                    String sql = "SELECT * FROM files WHERE subject=?";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, subject);
                    ResultSet rs = pstmt.executeQuery();
        
      out.write("\n");
      out.write("                    <table>\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Note Title</th> \n");
      out.write("                                <th>Note Content</th>\n");
      out.write("                                <th>Author</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("        ");

                            // Display fetched notes
                            while (rs.next()) {
                                String file = rs.getString("fileLoc");
        
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><a href=\"");
      out.print( file );
      out.write('"');
      out.write('>');
      out.print( rs.getString("fileName") );
      out.write("</a></td>\n");
      out.write("                                    <td>");
      out.print( rs.getString("topic") );
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( rs.getString("author") );
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("        ");

                            }
                            con.close();
                        } catch (Exception e) {
                            out.println(e);
                        }
        
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("        ");

                }
        
      out.write("\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
