<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h3 {
            margin-bottom: 20px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3>Registration Page</h3>
        <form name="f2" action="/onlineQuiz/RegisterServlet" method="post" onsubmit="return validate()">
            Name <input type="text" name="name"/><br>
            Username <input type="text" name="username"/><br>
            Password <input type="password" name="password"/><br>
            Retype Password <input type="password" name="repassword"/><br>
            <input type="submit" value="Register"/>
        </form>
    </div>
    <script>
        function validate() {
            var x1 = document.f2.name.value;
            var x2 = document.f2.username.value;
            var x3 = document.f2.password.value;
            var x4 = document.f2.repassword.value;
            if (x1 == "" || x1 == null) {
                alert("Name should not be empty");
                return false;
            }
            if (x2 == "" || x2 == null) {
                alert("Username should not be empty");
                return false;
            }
            if (x3 == "" || x3 == null) {
                alert("Password should not be empty");
                return false;
            }
            if (x3 != x4) {
                alert("Password and Retype Password should match");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>