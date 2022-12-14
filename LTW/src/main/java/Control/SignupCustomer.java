package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KhachHangDAO;
import Model.KhachHang;

@WebServlet(urlPatterns = { "/customer/signup" })
public class SignupCustomer extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/customer/signup.jsp");
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
		KhachHangDAO KHDao = new KhachHangDAO();
		KhachHang KH = new KhachHang();
		String msg = "";
		try {
			String destPage = "/views/customer/signup.jsp";
			KH.setTenKH(userName);
			KH.setTenTK(accountName);
			KH.setEmail(email);
			KH.setDiaChi(address);
			KH.setMK(password);
			KH.setPhone(phone);
			KH.setRole(3);
			KH.setIsDeleted(0);

			if (KHDao.findVendorByAccountName(accountName) == null) {
				destPage = "/views/customer/login.jsp";
				KHDao.createVendor(KH);
			} else {
				msg = "Tài khoản đã tồn tại";
				req.setAttribute("msg", msg);
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
