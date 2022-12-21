package Control;

import java.io.IOException;

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

@WebServlet(urlPatterns = {"/vendor/shop/profile", "/vendor/shop/profile/edit"})
public class ShopProfile extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		
		
		req.getRequestDispatcher("/views/vendor/shopprofile.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = req.getSession();
		
		KhachHangDAO khDao = new KhachHangDAO();
		ShopDAO shopDao = new ShopDAO();
		String maShop = req.getParameter("MaShop");

		Shop shop = shopDao.getShopByMaShop(Integer.parseInt(maShop));
		KhachHang vendor = khDao.findVendorById(Integer.parseInt(req.getParameter("MaSeller")));
		String tenShop = req.getParameter("TenShop");
		String email = req.getParameter("EmailShop");
		String phone = req.getParameter("PhoneShop");
		String diaChi = req.getParameter("DiaChiShop");
		
		
		
		try {
			shop.setTenShop(tenShop);
			shop.setEmailShop(email);
			shop.setPhoneShop(phone);
			shop.setDiaChiShop(diaChi);
			
			shopDao.EditProfile(shop);
			
			
			session.setAttribute("Shop", shop);
			session.setAttribute("Vendor", vendor);
			
			session.setAttribute("msgShop", "Thay đổi thông tin thành công");
			resp.sendRedirect(req.getContextPath() + "/vendor/shop/profile");
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
