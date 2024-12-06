package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie c1 = new Cookie("uname", "");
		c1.setMaxAge(0);
		resp.addCookie(c1);
		Cookie c2 = new Cookie("role", "");
		c2.setMaxAge(0);
		resp.addCookie(c2);
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login</title>");
		out.println("</head>");
		ServletContext col = req.getServletContext();
		String bgCol = col.getInitParameter("bg.color");
		out.printf("<body style='%s'>", bgCol);
		ServletContext app = req.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		out.printf("<h1>%s</h1>", appTitle);
		out.println("<h2>Thank You</h2> ");
		out.println("<p>See you after 5 years.</p>");
		out.println("<p><a href='index.html'>Login Again</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
