import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class updateProfileServlet extends HttpServlet {
    Connection con;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String newPassword = request.getParameter("password");
        HttpSession session = request.getSession();
        String currentUsername = (String) session.getAttribute("username");

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE users SET username=?, name=? , password=? WHERE username=?");
            ps.setString(1, username);
            ps.setString(2, name);
            ps.setString(3, newPassword);
            ps.setString(4, currentUsername);
            int i = ps.executeUpdate();

            if (i > 0) {
                session.setAttribute("username", username);
                session.setAttribute("name", name);
                response.sendRedirect("dashBoard.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
