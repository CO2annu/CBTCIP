import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class onlineQuizSubmit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Array of correct answers
        String[] correctAnswers = { "c", "b", "b", "a", "b", "a", "b", "a", "b", "b" };
        int score = 0;

        // Check answers
        for (int i = 1; i <= 10; i++) {
            String userAnswer = request.getParameter("q" + i);
            if (userAnswer != null && userAnswer.equals(correctAnswers[i - 1])) {
                score++;
            }
        }

        // Store score in session
        HttpSession session = request.getSession();
        session.setAttribute("score", score);

        // Redirect to results page
        response.sendRedirect("results.jsp");
    }
}

