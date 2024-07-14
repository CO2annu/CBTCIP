

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class loginServlet extends HttpServlet {
	Connection con;
	public void init(ServletConfig config)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root" , "root");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			PreparedStatement st = con.prepareStatement("select * from users where username = '"+username+"' and password = '"+password+"'");
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				 HttpSession session = request.getSession();
	                session.setAttribute("username", username);
	                String name = rs.getString("name");
	                session.setAttribute("name", name);

	                // Redirect to dashboard.jsp
	                response.sendRedirect("dashBoard.jsp");
			}
			else {
				request.setAttribute("errorMessage", "Username or password is incorrect");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
			}
		}
		catch(Exception e) {
			out.println(e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void destroy()
	{
		try {
			con.close();
		}
		catch(Exception e) {
			
		}
	}
}
