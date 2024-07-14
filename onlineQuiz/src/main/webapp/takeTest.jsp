<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Take Test</title>
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
            background: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }
        h1 {
            color: #333;
        }
        .question {
            margin-bottom: 20px;
        }
        .question h3 {
            color: #333;
        }
        .options input[type="radio"] {
            margin-right: 10px;
        }
        .submit-button {
            display: block;
            width: 100px;
            margin: 20px auto;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .submit-button:hover {
            background-color: #45a049;
        }
        .timer {
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 20px;
        }
    </style>
    <script>
        var totalTime = 600; // Total time in seconds (e.g., 600 seconds = 10 minutes)
        var timer;

        function startTimer() {
            var minutes, seconds;
            timer = setInterval(function () {
                minutes = parseInt(totalTime / 60, 10);
                seconds = parseInt(totalTime % 60, 10);

                minutes = minutes < 10 ? "0" + minutes : minutes;
                seconds = seconds < 10 ? "0" + seconds : seconds;

                document.getElementById("timer").textContent = minutes + ":" + seconds;

                if (--totalTime < 0) {
                    clearInterval(timer);
                    document.getElementById("quizForm").submit();
                }
            }, 1000);
        }

        window.onload = function () {
            startTimer();
        };
    </script>
</head>
<body>
    <div class="container">
        <h1>Java Quiz</h1>
        <div class="timer">Time Left: <span id="timer">10:00</span></div>
        <form id="quizForm" action="onlineQuizSubmit" method="post">
            <!-- Question 1 -->
            <div class="question">
                <h3>1. What is the size of an int variable in Java?</h3>
                <div class="options">
                    <input type="radio" name="q1" value="a"> 1 byte<br>
                    <input type="radio" name="q1" value="b"> 2 bytes<br>
                    <input type="radio" name="q1" value="c"> 4 bytes<br>
                    <input type="radio" name="q1" value="d"> 8 bytes<br>
                </div>
            </div>
            <!-- Question 2 -->
            <div class="question">
                <h3>2. Which of the following is not a Java feature?</h3>
                <div class="options">
                    <input type="radio" name="q2" value="a"> Object-oriented<br>
                    <input type="radio" name="q2" value="b"> Use of pointers<br>
                    <input type="radio" name="q2" value="c"> Portable<br>
                    <input type="radio" name="q2" value="d"> Dynamic<br>
                </div>
            </div>
            <!-- Question 3 -->
            <div class="question">
                <h3>3. Which of these cannot be used for a variable name in Java?</h3>
                <div class="options">
                    <input type="radio" name="q3" value="a"> identifier<br>
                    <input type="radio" name="q3" value="b"> keyword<br>
                    <input type="radio" name="q3" value="c"> identifier & keyword<br>
                    <input type="radio" name="q3" value="d"> none of the mentioned<br>
                </div>
            </div>
            <!-- Question 4 -->
            <div class="question">
                <h3>4. What is the return type of the hashCode() method in the Object class?</h3>
                <div class="options">
                    <input type="radio" name="q4" value="a"> int<br>
                    <input type="radio" name="q4" value="b"> Object<br>
                    <input type="radio" name="q4" value="c"> long<br>
                    <input type="radio" name="q4" value="d"> void<br>
                </div>
            </div>
            <!-- Question 5 -->
            <div class="question">
                <h3>5. Which of these classes are the direct subclasses of the Throwable class?</h3>
                <div class="options">
                    <input type="radio" name="q5" value="a"> RuntimeException and Error<br>
                    <input type="radio" name="q5" value="b"> Exception and Error<br>
                    <input type="radio" name="q5" value="c"> IOException and RuntimeException<br>
                    <input type="radio" name="q5" value="d"> None of the mentioned<br>
                </div>
            </div>
            <!-- Question 6 -->
            <div class="question">
                <h3>6. Which of these keywords is used to define interfaces in Java?</h3>
                <div class="options">
                    <input type="radio" name="q6" value="a"> interface<br>
                    <input type="radio" name="q6" value="b"> intf<br>
                    <input type="radio" name="q6" value="c"> intface<br>
                    <input type="radio" name="q6" value="d"> None of the mentioned<br>
                </div>
            </div>
            <!-- Question 7 -->
            <div class="question">
                <h3>7. Which of the following is a reserved keyword in Java?</h3>
                <div class="options">
                    <input type="radio" name="q7" value="a"> object<br>
                    <input type="radio" name="q7" value="b"> strictfp<br>
                    <input type="radio" name="q7" value="c"> main<br>
                    <input type="radio" name="q7" value="d"> system<br>
                </div>
            </div>
            <!-- Question 8 -->
            <div class="question">
                <h3>8. Which method can be used to create a new thread?</h3>
                <div class="options">
                    <input type="radio" name="q8" value="a"> start()<br>
                    <input type="radio" name="q8" value="b"> run()<br>
                    <input type="radio" name="q8" value="c"> new()<br>
                    <input type="radio" name="q8" value="d"> init()<br>
                </div>
            </div>
            <!-- Question 9 -->
            <div class="question">
                <h3>9. Which of these packages contains the exception StackOverflowError?</h3>
                <div class="options">
                    <input type="radio" name="q9" value="a"> java.io<br>
                    <input type="radio" name="q9" value="b"> java.lang<br>
                    <input type="radio" name="q9" value="c"> java.system<br>
                    <input type="radio" name="q9" value="d"> java.util<br>
                </div>
            </div>
            <!-- Question 10 -->
            <div class="question">
                <h3>10. Which of these is not a feature of Java?</h3>
                <div class="options">
                    <input type="radio" name="q10" value="a"> Object-oriented<br>
                    <input type="radio" name="q10" value="b"> Use of pointers<br>
                    <input type="radio" name="q10" value="c"> Portable<br>
                    <input type="radio" name="q10" value="d"> Dynamic<br>
                </div>
            </div>
            <input type="submit" value="Submit" class="submit-button">
        </form>
    </div>
</body>
</html>
