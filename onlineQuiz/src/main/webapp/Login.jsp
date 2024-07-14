<html>
<head>
    <title>Online Quiz Login</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
            font-family: Arial, sans-serif;
        }
        form {
            text-align: center;
        }
        h1 {
            font-size: 2em;
            font-weight: bold;
        }
        input[type="text"], input[type="password"] {
            display: block;
            margin: 10px auto;
        }
        input[type="submit"] {
            display: block;
            margin: 20px auto;
        }
        .error {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Online Quiz Login</h1>
    <form name="f1" action="/onlineQuiz/loginServlet" method="post" onSubmit="return validate()">
        Username: <input type="text" name="username"/><br>
        Password: <input type="password" name="password"/><br>
        <input type="submit" value="Login"/>
    </form>
    <div style="text-align: center;">
        New User <a href="Register.jsp">Register</a>
    </div>
     <div class="error">
        <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
                out.println(errorMessage);
            }
        %>
    </div>
    <script>
        function validate() {
            var x1 = document.f1.username.value;
            if (x1 == "" || x1 == null) {
                alert("Username should not be empty");
                return false;
            }
            var x2 = document.f1.password.value;
            if (x2 == "" || x2 == null) {
                alert("Password should not be empty");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
