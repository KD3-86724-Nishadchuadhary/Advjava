package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		ServletContext col = req.getServletContext();
		String bgCol = col.getInitParameter("bg.color");
		out.printf("<body>");
		
		ServletContext app = req.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		out.printf("<h1>%s</h1>", appTitle);
		
		try(UserDao usrDao = new UserDaoImpl()){
			String fname = req.getParameter("fname");
			String lname = req.getParameter("lname");
			String email = req.getParameter("email");
			String password = req.getParameter("passwd");
			String dob = req.getParameter("birthdate");
			Date d = Date.valueOf(dob);
			
			int status = 0;
			
			String role = "voter";
			User u = new User(status, fname, lname, email, password, d, status, role);
			int cnt = usrDao.save(u);
			if(cnt == 1) {
				out.println("<h4>You have successfully Registered a new user!</h4>");
			}
			else {
				out.println("<h4>Your Registration failed</h4>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	

}
