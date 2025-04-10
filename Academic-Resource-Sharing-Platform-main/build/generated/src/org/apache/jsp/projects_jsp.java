package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class projects_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Portfolio - Sachin Prajapati</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            background-color: #f4f4f4;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .small-container {\n");
      out.write("            max-width: 1200px;\n");
      out.write("            margin: auto;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .title {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-bottom: 40px;\n");
      out.write("            font-size: 32px;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-card-container {\n");
      out.write("            display: flex;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            gap: 20px;\n");
      out.write("            justify-content: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-card {\n");
      out.write("            background-color: #fff;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            padding: 20px;\n");
      out.write("            width: calc(33.333% - 20px);\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n");
      out.write("            transition: transform 0.3s ease, box-shadow 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-card:hover {\n");
      out.write("            transform: translateY(-5px);\n");
      out.write("            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-card-title {\n");
      out.write("            font-size: 24px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-card-author {\n");
      out.write("            font-size: 18px;\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("            color: #777;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-card-description {\n");
      out.write("            font-size: 16px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            color: #555;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-card-link a {\n");
      out.write("            color: #333;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-card-link a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"small-container\">\n");
      out.write("        <h2 class=\"title\">Projects</h2>\n");
      out.write("        <div class=\"project-card-container\">\n");
      out.write("            <!-- Project Cards will be inserted here by JSP -->\n");
      out.write("            ");

                Connection con = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                try {
                    con = DbConnect.getConn();
                    String sql = "SELECT * FROM project";
                    pstmt = con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
            
      out.write("\n");
      out.write("            <div class=\"project-card\">\n");
      out.write("                <h2 class=\"project-card-title\">");
      out.print( rs.getString("P_name") );
      out.write("</h2>\n");
      out.write("                <h3 class=\"project-card-author\">by ");
      out.print( rs.getString("P_author") );
      out.write("</h3>\n");
      out.write("                <div class=\"project-card-description\">");
      out.print( rs.getString("P_description") );
      out.write("</div>\n");
      out.write("                <div class=\"project-card-link\">\n");
      out.write("                    <a href=\"");
      out.print( rs.getString("P_repo") );
      out.write("\" target=\"_blank\"><i class=\"fa-brands fa-github\"></i> Repository Link</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

                    }
                } catch (SQLException e) {
                    out.println(e);
                } finally {
                    if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
                    if (pstmt != null) try { pstmt.close(); } catch (SQLException ignore) {}
                    if (con != null) try { con.close(); } catch (SQLException ignore) {}
                }
            
      out.write("\n");
      out.write("        </div>\n");
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
