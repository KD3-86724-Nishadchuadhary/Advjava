package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	private ArrayList<Marks> result;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		result = new ArrayList<Marks>();
		result.add(new Marks("Database Technologies", 25.0));
		result.add(new Marks("C++ Programming", 36.0));
		result.add(new Marks("Web Programming", 25.0));
		result.add(new Marks("Java Programming", 36.0));
		result.add(new Marks("DSA using Java", 36.0));
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Home</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<th>Subject</th>");
		out.println("<th>Marks</th>");
		out.println("</tr>");
	
		for(Marks m: result) {
			out.println("<tr>");
			out.printf("<td>%s</td>", m.getSubject());
			out.printf("<td>%.2f</td>", m.getMarks());
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
