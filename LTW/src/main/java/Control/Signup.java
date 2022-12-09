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

@WebServlet(urlPatterns = {"/guest/signup", "/login"})
public class Signup extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/guest/signup.jsp");
		dispatcher.forward(req, resp);
        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        
        String userName = req.getParameter("TenKH");
        String accountName = req.getParameter("TenTK");
        String password = req.getParameter("MK");
        String email = req.getParameter("Email");
        String phone = req.getParameter("Phone");
        String address = req.getParameter("DiaChi");

        System.out.print(userName);
        System.out.print(accountName);
        System.out.print(password);
        System.out.print(email);
        System.out.print(phone);
        KhachHangDAO KHDao = new KhachHangDAO();
        KhachHang KH = new KhachHang();
        try {
        	
        	
        	KH.setTenKH(accountName);
        	KH.setTenTK(userName);
        	KH.setEmail(email);
        	KH.setDiaChi(address);
        	KH.setMK(password);
        	KH.setNNMK(null);
        	KH.setPhone(phone);
        	KH.setIsVeify(1);
        	KH.setRole(2);
        	
        	KHDao.create(KH);
        	
        	resp.sendRedirect(req.getContextPath()+"/login");
        	      	
        }catch(Exception e) {
        	e.printStackTrace();
        }       
	}
	
}
