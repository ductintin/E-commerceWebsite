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

@WebServlet(urlPatterns = {"/vendor/changepassword"})
public class ChangePasswordVendor extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/vendor/changepassword.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		KhachHang vendor = (KhachHang)session.getAttribute("Vendor");
		KhachHangDAO KHDao = new KhachHangDAO();
		String old_password = req.getParameter("oldpw");
		String new_password = req.getParameter("newpw");
		String confirm_password = req.getParameter("confirmnewpw"); 

		try {
			if (!vendor.getMK().equals(old_password)) {
				session.setAttribute("msg", "Mật khẩu cũ không đúng!!!");
				req.getRequestDispatcher("/views/vendor/changepassword.jsp").forward(req, resp);
			} else if (!new_password.equals(confirm_password)) {
				session.setAttribute("msg", "Mật khẩu xác nhận không đúng!!!");
				req.getRequestDispatcher("/views/vendor/changepassword.jsp").forward(req, resp);
			} else {
				
				KHDao.ChangePasswordCustomer(vendor.getTenTK(), new_password);
				session.setAttribute("msg", "Đổi mật khẩu thành công!!!");
				resp.sendRedirect(req.getContextPath() + "/vendor/home");

			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
