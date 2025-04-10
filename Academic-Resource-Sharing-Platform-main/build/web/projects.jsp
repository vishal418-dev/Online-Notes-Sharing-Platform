<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.*" %>
<%@ page import="servlets.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Projects</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://kit-free.fontawesome.com/releases/latest/css/free.min.css" media="all" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link rel="shortcut icon" href="./images/logo1.png" type="image/x-icon">
    <link rel="apple-touch-icon" sizes="180x180" href="images/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="images/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon-16x16.png">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
   

</head>
<body style="background: radial-gradient(#1e879f,#325dc1)">
    
    <div class="project-container small-container">
        <h2 class="title">Submit your Own Project</h2>
        <div class="project-form-container">
            <form class="project-form" action="uploadProject" method="post" >
                <div class="form-input-group">
                    <label for="project-name">Project Name: </label>
                    <br>
                    <input class="form-input" type="text" name="pname" placeholder="Your project's Name." required>
                </div>
                <div class="form-input-group">
                    <label for="project-author">Project Author(s): </label>
                    <br>
                    <input class="form-input" type="text" name="author" placeholder="Your project's Authors" required>
                </div>
                <div class="form-input-group">
                    <label for="project-description">Project Description:</label>
                    <br>
                    <input type="text" class="form-input" name="description" placeholder="Few words about your project." required>
                </div>
                <div class="form-input-group">
                    <label for="project-link">Repository Link (Github)<i class="fa-brands fa-github"></i> :</label>
                    <br>
                    <input class="form-input" type="text" name="repolink" placeholder="Repository Link" required>
                </div>
                <div class="form-input-group">
                    <button class="btn" type="submit">Submit Project</button>
                </div>
            </form>
        </div>
    </div>  
                
                <%
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        con = DbConnect.getConn();
        String sql = "SELECT * FROM project";
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();
%>
<div class="small-container">
    <h2 class="project-section-title title">Projects</h2>
    <div class="project-card-container">
<%
        while (rs.next()) {
%>
        <div class="project-card"  style="background-color: white ; box-shadow: offset-x offset-y blur-radius spread-radius color">
            <h2 class="project-card-title"><%= rs.getString("P_name") %></h2>
            <h3 class="project-card-author">by <%= rs.getString("P_author") %></h3>
            <div class="project-card-description"><%= rs.getString("P_description") %></div>
            <div class="project-card-link">
                <a href="<%= rs.getString("P_repo") %>" target="_blank"><i class="fa-brands fa-github"></i> Repository Link</a>
            </div>
        </div>
<%
        }
    } catch (SQLException e) {
        out.println(e);
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        if (pstmt != null) try { pstmt.close(); } catch (SQLException ignore) {}
        if (con != null) try { con.close(); } catch (SQLException ignore) {}
    }
%>
    </div>
</div>

</body>
</html>
