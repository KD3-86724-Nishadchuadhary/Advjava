package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/candreg")
public class AddCandidateServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(CandidateDao candDao = new CandidateDaoImpl()){
			String name = req.getParameter("name");
			String pname = req.getParameter("pname");
			String votes = req.getParameter("votes");
			int v = Integer.parseInt(votes);
			
			Candidate c = new Candidate(0, name, pname, v);
			
			int cnt = candDao.Save(c);
			
			if(cnt == 1) {
				resp.sendRedirect("result");
			}
			else {
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
				out.println("<h2>Adding Failed</h2>");
				out.println("<p>Candidate Registration Faild</p>");
				out.println("<p><a href='index.html'>Login Again</a></p>");
				out.println("</body>");
				out.println("</html>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
	}
}
