package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KhachHangDAO;
import Model.KhachHang;

@WebServlet(urlPatterns = {"/vendor/login"})
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        
        KhachHangDAO KHDao = new KhachHangDAO();
        KhachHang KH = new KhachHang();
        
        String accountName = req.getParameter("TenTK");
        String password = req.getParameter("MK");
        
        String destPage = "/views/vendor/login.jsp";
        try {
        	KH = KHDao.login(accountName, password);
        	
        	System.out.print(KH);
        	if(KH != null) {
        		HttpSession session = req.getSession();
        		session.setAttribute("user", KH);
        		destPage = "/views/vendor/home.jsp";
        		    		
        	}else {
        		String msg = "Tài khoản không hợp lệ";
        		req.setAttribute("msg", msg);
        	}
        	
        	RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
    		dispatcher.forward(req, resp);;  
        }catch(Exception e) {       	
        	System.out.print(e);        	        	
        }
        
        
	}
}
