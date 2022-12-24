package Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KhachHangDAO;
import Model.KhachHang;

@WebServlet(urlPatterns = {"/vendor/profile", "/vendor/profile/edit"})
public class ProfileVendor extends HttpServlet{

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
		
		req.getRequestDispatcher("/views/vendor/profile.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = req.getSession();
		KhachHangDAO khDao = new KhachHangDAO();
		String accountname = req.getParameter("TenTK");
		KhachHang vendor = khDao.findVendorByAccountName(accountname) ;
		
		String accountName = req.getParameter("TenKH");
		String email = req.getParameter("Email");
		String phone = req.getParameter("Phone");
		String diaChi = req.getParameter("DiaChi");
		try {
			vendor.setTenKH(accountName);
			vendor.setEmail(email);
			vendor.setPhone(phone);
			vendor.setDiaChi(diaChi);
			
			khDao.EditProfile(vendor);
			
			
			session.setAttribute("Vendor", vendor);
			
			session.setAttribute("msgProfile", "Thay đổi thông tin thành công");
			resp.sendRedirect(req.getContextPath() + "/vendor/profile");
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
