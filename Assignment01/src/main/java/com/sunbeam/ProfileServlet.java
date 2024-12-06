package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Home</title>");
		out.println("</head>");
		out.println("<body bgcolor='pink'>");
		out.println("<h3>First Name: Omkar</h3>");
		out.println("<h3>Last Name: Bhise</h3>");
		out.println("<h3>Qualification: UG-B.Tech</h3>");
		out.println("<h3>Collage: DKTE</h3>");
		out.println("<h3>Birth Date: 03/08/2001</h3>");
		
		
		out.println("</body>");
		out.println("</html>");
		
	}
}
