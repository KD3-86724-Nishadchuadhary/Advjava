package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
import com.sunbeam.entities.Candidate;

@WebServlet("/candlist")
public class CandidateServletList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> list = new ArrayList<Candidate>();
		
		try(CandidateDao candDao = new CandidateDaoImpl()){
			list = candDao.findAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		ServletContext col = req.getServletContext();
		String bgCol = col.getInitParameter("bg.color");
		out.printf("<body style='%s'>", bgCol);
		
		ServletContext app = req.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		out.printf("<h1>%s</h1>", appTitle);
		
		Cookie arr[] = req.getCookies();
		String userName = "", role = "";
		if(arr != null) {
			for(Cookie c : arr) {
				if(c.getName().equals("uname")) {
					userName = c.getValue();
				}
				if(c.getName().equals("role")) {
					role = c.getValue();
				}
			}
		}
		HttpSession session = req.getSession(false);
		if(session == null) {
			resp.sendError(440);
			return;
		}
		
		
		out.printf("Hello, %s (%s)<hr/>\n", userName, role);
		
		ServletContext ctx = this.getServletContext();
		String ann = (String) ctx.getAttribute("annoucement");
		if(ann != null) {
			out.println("<p style='color:red'> Note: " + ann + "</p>");
		}
		out.println("<h2>Candidate List</h2>");
		out.println("<form method='post' action='vote'>");
		for(Candidate c : list) {
			out.printf("<input type='radio' name='candidate' value='%d'/> %s </br>\n", 
							c.getId(), c.getName());
		}
		out.println("</br><input type='submit' value='Vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
