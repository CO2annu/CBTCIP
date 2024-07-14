<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
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
            text-align: center;
            width: 50%;
        }
        h1 {
            color: #333;
        }
        .score {
            font-size: 24px;
            margin: 20px 0;
        }
        .retry-button, .logout-button {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .retry-button:hover, .logout-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Quiz Results</h1>
        <h1> hii , <%= session.getAttribute("name") %></h1>
        <div class="score">
            <%
                Integer score = (Integer) session.getAttribute("score");
            	
                if (score != null) {
                	
                    out.print(" your score is: " + score + " out of 10");
                } else {
                    out.print("No score available.");
                }
            %>
        </div>
        <a href="takeTest.jsp" class="retry-button">Retry</a>
        <a href="logoutServlet" class="logout-button">Logout</a>
    </div>
</body>
</html>