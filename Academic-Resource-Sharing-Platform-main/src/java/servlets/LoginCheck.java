package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LoginCheck extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("username");
		String s2=request.getParameter("password");

		
	  try {
            Connection con=DbConnect.getConn();

            String sql = "SELECT * FROM auth WHERE U_name=? AND U_pass=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, s1);
            pstmt.setString(2, s2);

            ResultSet rs = pstmt.executeQuery();
            System.out.println(s1 + s2);
            System.out.println(rs);
            if (rs.next()) {
                response.sendRedirect("home.html");
            } else {
                out.write("<script>alert('Enter Valid Username and Password'); window.location.href='index.html';</script>");
            }
	   
	   con.close();
	   }
	   catch(Exception e)
	   {
		   out.println(e);
	   }
	   out.close();
}
}