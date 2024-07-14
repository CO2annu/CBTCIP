<%@ page import="java.util.*, java.sql.*" session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        header {
            background: #50b3a2;
            color: #ffffff;
            padding-top: 30px;
            min-height: 70px;
            border-bottom: #ffffff 3px solid;
        }
        header a {
            color: #ffffff;
            font-size: 16px;
            text-decoration: none;
            text-transform: uppercase;
        }
        header ul {
            padding: 0;
            list-style: none;
        }
        header li {
            float: right;
            display: inline;
            padding: 0 20px 0 20px;
        }
        .main-content {
            background: #ffffff;
            padding: 20px;
            margin-top: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .main-content h2 {
            color: #333;
        }
        .main-content p {
            color: #666;
        }
        .button {
            display: block;
            width: 200px;
            margin: 20px auto;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
        }
        .button:hover {
            background-color: #45a049;
        }
        .profile-button {
            background-color: #2196F3;
        }
        .profile-button:hover {
            background-color: #1976D2;
        }
        .profile-content {
            text-align: center;
            margin-top: 20px;
        }
        .update-profile-button {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #FF5722;
            color: white;
            text-align: center;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
        }
        .update-profile-button:hover {
            background-color: #E64A19;
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <h1>Welcome, <%
            	String username = (String)session.getAttribute("username");
            	String name = "";
            	Connection con = null;
            	try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
                    PreparedStatement ps = con.prepareStatement("SELECT name FROM users WHERE username = ?");
                    ps.setString(1, username);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        name = rs.getString("name");
                        session.setAttribute("name", name);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (con != null) con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            out.print(name);
            %></h1>
            <ul>
                <li><a href="logoutServlet">Logout</a></li>
            </ul>
        </div>
    </header>
    <div class="container main-content">
        <h2>Dashboard</h2>
        <p>Welcome to the Online Quiz System.</p>
        <!-- Take Test Button -->
        <a href="takeTest.jsp" class="button">Take Test</a>

        <!-- Profile Button -->
        <div class="profile-content">
            <h3>Profile</h3>
            <p>Username: <%= session.getAttribute("username") %></p>
            <p>Name: <%= session.getAttribute("name") %></p>
            <a href="updateProfile.jsp" class="update-profile-button">Update Profile</a>
        </div>
    </div>
</body>
</html>
