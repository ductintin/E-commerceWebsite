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
import DAO.ShopDAO;
import Model.KhachHang;
import Model.Shop;

@WebServlet(urlPatterns = {"/vendor/login", "/vendor"})
public class LoginVendor extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * HttpSession session = req.getSession(); if (session.getAttribute("Vendor") !=
		 * null) { resp.sendRedirect(req.getContextPath() + "/vendor/home"); } else {
		 * req.getRequestDispatcher("/views/vendor/login.jsp").forward(req, resp); }
		 */
        
		
		  RequestDispatcher dispatcher =
		  req.getRequestDispatcher("/views/vendor/login.jsp"); dispatcher.forward(req,
		  resp);
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        
        KhachHangDAO KHDao = new KhachHangDAO();
        KhachHang KH = new KhachHang();
        
        ShopDAO shopDao = new ShopDAO();
        Shop shop = new Shop();
        
        String accountName = req.getParameter("TenTK");
        String password = req.getParameter("MK");
        
        
        
        String destPage = "/views/vendor/login.jsp";
        try {
        	KH = KHDao.login(accountName, password);
        	
        	HttpSession session = req.getSession();
            
            session.setMaxInactiveInterval(10000*60);
        	System.out.print(KH);
        	if(KH != null) {
        		shop = shopDao.getShopByMaSeller(KH.getMaKH());
        		
        		session.setAttribute("Vendor", KH);
        		System.out.println("kh ne" + KH);
    			if(shop != null) {
    				session.setAttribute("Shop", shop);
    				System.out.println("Shop ne: "+ shop);
    			}else {
    				session.setAttribute("Shop", null);
    			}
        		
        		//Kiểm tra role của account để chuyển đến trang phù hợp
				/*
				 * if(KH.getRole()==1){
				 * 
				 * } else if(KH.getRole()==2) { destPage = "/views/vendor/home.jsp"; }else {
				 * 
				 * }
				 */
        		
        		//destPage = "/views/vendor/home.jsp";
        		resp.sendRedirect(req.getContextPath()+ "/vendor/home");	
        		
        	}else {
        		String msg = "Tài khoản không tồn tại";
        		req.setAttribute("msg", msg);
        	}
        	
        	RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
    		dispatcher.forward(req, resp);;  
        }catch(Exception e) {       	
        	System.out.print(e);        	        	
        }      
	}
}
