package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/vendor/home" })
public class IndexController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * String url = req.getRequestURL().toString(); if(url.contains("/store/add")) {
		 * RequestDispatcher dispatcher =
		 * req.getRequestDispatcher("/views/vendor/home.jsp"); dispatcher.forward(req,
		 * resp); }
		 */
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("Vendor");
		if(obj == null) {
			resp.sendRedirect(req.getContextPath() + "/vendor/login");
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/home.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 super.doPost(req, resp); 
				
		
	}

}