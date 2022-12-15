package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import DAO.KhachHangDAO;
import DAO.ShopDAO;
import Model.KhachHang;
import Model.Shop;

@WebServlet(urlPatterns = {"/vendor/store/add"})
public class AddStoreVendor extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/home.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        
		/* JSONObject obj = new JSONObject(req.getParameter("Vendor")); */
        
        
        ShopDAO shopDao = new ShopDAO();
        Shop shop = new Shop();
        
        String TenShop = req.getParameter("TenShop");
        //int MaSeller = KHDao.getIdVendorByAccountName(obj.get("MaKH").toString());
        
        int MaSeller = Integer.parseInt(req.getParameter("vendor"));
        String PhoneShop = req.getParameter("SDT");
        String DiaChi = req.getParameter("DiaChi");
        String EmailShop = req.getParameter("Email");
        
        System.out.print(req.getParameter("vendor"));
        System.out.print(PhoneShop);
        
        try {
	        	
			  shop.setTenShop(TenShop); shop.setMaSeller(MaSeller);
			  shop.setPhoneShop(PhoneShop); shop.setDiaChiShop(DiaChi);
			  shop.setEmailShop(EmailShop);
			  shop.setIsDeleted(0);
			  
			  shopDao.createShop(shop, MaSeller);
			  HttpSession session = req.getSession();
	    	  session.setAttribute("Shop", shop);
	    	  
	    	  System.out.println(shop);
			  
			  resp.sendRedirect(req.getContextPath()+ "/vendor/home");
			 
        	
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        
	}
	

}
