<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 50%;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        form {
            margin: 20px 0;
        }
        input[type="text"], input[type="password"] {
            display: block;
            width: 80%;
            margin: 10px auto;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            display: block;
            width: 60%;
            margin: 20px auto;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Update Profile</h2>
        <form action="updateProfileServlet" method="post">
            Username: <input type="text" name="username" value="<%= session.getAttribute("username") %>"/><br><br>
            Password: <input type="password" name="password"/><br><br>
            <input type="submit" value="Update Profile"/>
        </form>
    </div>
</body>
</html>
