<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="servlets.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <script>
        function redirectTo(fileLoc) {
            // Redirect to the fileLoc
            window.location.href = fileLoc;
        }
    </script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Best Engineering Notes</title>
    <link rel="stylesheet" href="style.css"> <!-- Assuming you have a separate CSS file -->
   <style>
    /* Center content in the body */
    body {
        display: flex;
        flex-direction: column; /* Align items vertically */
        justify-content: flex-start; /* Align items at the start of the body */
        align-items: center;
        height: 100vh;
        margin: 10px; /* 10px margin around the body */
        background: radial-gradient(#1e879f, #325dc1);
        font-family: Arial, sans-serif;
    }

    /* Center content in the form-container */
    .form-container {
        text-align: center;
        background: white;
        padding: 30px;
        border-radius: 50px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin-bottom: 30px;
        margin-top: 50px;
    }

    /* Style the table */
   table {
        width: 80%; /* Adjusted width for better centering */
        border-collapse: collapse;
        margin: 20px auto; /* Adjusted margin for spacing */
        font-size: 18px;
        text-align: left;
        border: 1px solid #ddd;
    }

    th, td {
        padding: 12px;
        border: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
    }

    /* Style for select optgroup */
    select optgroup {
        font-weight: bold;
        color: #333;
        font-size: 16px;
        padding: 8px 0;
    }

    select optgroup option {
        padding-left: 20px;
    }

    .btn {
        display: inline-block;
        background: #ff523b;
        color: #fff;
        padding: 8px 30px;
        margin-top: 20px;
        border-radius: 30px;
        transition: 0.5s;
        cursor: pointer;
    }
</style>
</head>
<body>
     <div class="navbar">
                <div class="logo">
                    <a href="https://www.svvv.edu.in/"><img src="images/logo1.png" alt="SVVV" width="50px" target="_blank" style="border-radius: 100%;"></a>
                </div>
                <nav>
                    <ul>
                        <li><a class="nav-link" href="./home.html">Home</a></li>
                        <li><a class="nav-link" href="./projects.jsp">Projects</a></li>
                        <li><a class="nav-link" href="./library.html">Library</a></li>
                        <li><a class="nav-link" href="./upload.html">Upload</a></li>
                        <li><a class="nav-link" href="./view.jsp">View Notes</a></li>
                        <li><a class="nav-link" href="https://svvv.edu.in/department/DisplayDeptPage.aspx?page=gaeoo&ItemID=gaeke&nDeptID=ec">Syllabus</a></li>
                        

                        <li>

                            <form id="search-form" action="#" method="GET">
                                <input id="search-input" type="text" placeholder="Search...">
                                <button id="search-button" type="submit"><a id="mike-button" href="#"><i
                                    class="mic fa-solid fa-microphone"></i></a>
                            
                        </li>
                    </ul>
                </nav>
            </div>
    <br><br><br>
    <div class="form-container">
        <h2>Select Subject</h2>

        <!-- Form with select, file input, and submit button -->
        <form action="<%= request.getContextPath() %>/view.jsp" method="post" style="background: white; border-radius: 50px; padding: 20px;">
            <select name="subject" id="subjectSelect">
                <optgroup label="CSE">
                    <optgroup label="1st Sem">
                        <option value="data-structures">Data Structures</option>
                        <option value="programming-fundamentals">Programming Fundamentals</option>
                        <option value="digital-logic">Digital Logic</option>
                    </optgroup>
                    <optgroup label="2nd Sem">
                        <option value="algorithms">Algorithms</option>
                        <option value="database-management">Database Management</option>
                        <option value="computer-networks">Computer Networks</option>
                    </optgroup>
                     <optgroup label="3rd Sem">
                        <option value="data-structures">Data Structures</option>
                        <option value="programming-fundamentals">Programming Fundamentals</option>
                        <option value="digital-logic">Digital Logic</option>
                    </optgroup>
                    <optgroup label="4th Sem">
                        <option value="algorithms">Algorithms</option>
                        <option value="database-management">Database Management</option>
                        <option value="computer-networks">Computer Networks</option>
                    </optgroup>
                    <optgroup label="5th Sem">
                        <option value="data-structures">Data Structures</option>
                        <option value="programming-fundamentals">Programming Fundamentals</option>
                        <option value="digital-logic">Digital Logic</option>
                    </optgroup>
                    <optgroup label="6th Sem">
                        <option value="algorithms">Algorithms</option>
                        <option value="database-management">Database Management</option>
                        <option value="computer-networks">Computer Networks</option>
                    </optgroup>
                    <optgroup label="7th Sem">
                        <option value="data-structures">Data Structures</option>
                        <option value="programming-fundamentals">Programming Fundamentals</option>
                        <option value="digital-logic">Digital Logic</option>
                    </optgroup>
                    <optgroup label="8th Sem">
                        <option value="algorithms">Algorithms</option>
                        <option value="database-management">Database Management</option>
                        <option value="computer-networks">Computer Networks</option>
                    </optgroup>
                    <!-- Add more semesters and subjects for CSE -->
                <optgroup label="ME">
                    <!-- ME semesters and subjects -->
                </optgroup>
                <optgroup label="EEE">
                    <!-- EEE semesters and subjects -->
                </optgroup>
                <optgroup label="CE">
                    <!-- CE semesters and subjects -->
                </optgroup>
                <optgroup label="EE">
                    <!-- EE semesters and subjects -->
                </optgroup>
                    <!-- Add more semesters and subjects as needed -->
                <!-- Add other branches like ME, EEE, CE, EE here -->
            </select>

            <input type="submit" value="Submit" class="btn">
        </form>
    </div>
    
    <!-- Display fetched notes here -->
    <table>
        <thead>
            <tr>
                <th>Note Title</th> 
                <th>Note Content</th>
                <th>Author</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Process form submission
               
                    // Retrieve form parameters
                    String subject = request.getParameter("subject");

                    // Fetch notes from the database based on selected criteria
                    try {
                        Connection con = DbConnect.getConn();
                        String sql = "SELECT * FROM files WHERE subject=?";
                        PreparedStatement pstmt = con.prepareStatement(sql);
                        pstmt.setString(1, subject);
                        ResultSet rs = pstmt.executeQuery();

                        // Display fetched notes
                        while (rs.next()) {
                            String file = rs.getString("fileLoc");
            %>
                            <tr>
                                <td><a href="<%= file %>"><%= rs.getString("fileName") %></a></td>
                                <td><%= rs.getString("topic") %></td>
                                <td><%= rs.getString("author") %></td>
                            </tr>
            <%
                        }
                        con.close();
                    } catch (Exception e) {
                        out.println(e);
                    }
                
            %>
        </tbody>
    </table>
</body>
</html>
