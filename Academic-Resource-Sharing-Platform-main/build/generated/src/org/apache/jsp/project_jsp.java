package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class project_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>projects</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("    <link rel=\"shortcut icon\" href=\"./images/logo1.png\" type=\"image/x-icon\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"images/apple-touch-icon.png\">\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"images/favicon-32x32.png\">\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"images/favicon-16x16.png\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Poppins&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https//stackpath.bootsstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://kit-free.fontawesome.com/releases/latest/css/free.min.css\" media=\"all\" crossorigin=\"anonymous\">\n");
      out.write("    <script src=\"https://kit.fontawesome.com/c4254e24a8.js\"></script>\n");
      out.write("    <script src=\"https://kit.fontawesome.com/739255457e.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://kit.fontawesome.com/YOUR_KIT_CODE.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("      ");

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
      out.write("                                <th>Note Title</th>\n");
      out.write("                                <th>Note Content</th>\n");
      out.write("                                <th>Author</th>\n");
      out.write("                                <!-- Add more columns as needed -->\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("        ");

                            // Display fetched notes
                            while (rs.next()) {
                                String file = rs.getString("fileLoc");
        
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td> <a href=\"");
      out.print( file);
      out.write('"');
      out.write('>');
      out.print(rs.getString("fileName"));
      out.write("</a></td>\n");
      out.write("                                    <td>");
      out.print( rs.getString("topic") );
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( rs.getString("author") );
      out.write("</td>\n");
      out.write("                                    \n");
      out.write("                                    <!-- Add more columns as needed -->\n");
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
      out.write("\n");
      out.write("<div class=\"project-container small-container\">\n");
      out.write("    <h2 class=\"title\">Submit your Own Project</h2>\n");
      out.write("    <div class=\"project-form-container\">\n");
      out.write("        <form class=\"project-form\" action=\"uploadProject\" method=\"post\">\n");
      out.write("            <div class=\"form-input-group\">\n");
      out.write("                <label for=\"project-name\">Project Name: </label>\n");
      out.write("                <br>\n");
      out.write("                <input class=\"form-input\" type=\"text\"  name=\"pname\" placeholder=\"Your project's Name.\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-input-group\">\n");
      out.write("                <label for=\"project-author\">Project Author(s): </label>\n");
      out.write("                <br>\n");
      out.write("                <input class=\"form-input\" type=\"text\"  name=\"author\" placeholder=\"Your project's Authors\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-input-group\">\n");
      out.write("                <label for=\"project-description\">Project Description:</label>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"text\" class=\"form-input\"  name=\"discription\" placeholder=\"Few words about your project.\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-input-group\">\n");
      out.write("                <label for=\"project-link\">Repository Link (Github)<i class=\"fa-brands fa-github\"></i> :</label>\n");
      out.write("                <br>\n");
      out.write("                <input class=\"form-input\" type=\"text\"  name=\"repolink\" placeholder=\"Repository Link\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-input-group\">\n");
      out.write("                <button class=\"btn\" type=\"submit\">Submit Project</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</div>     \n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
