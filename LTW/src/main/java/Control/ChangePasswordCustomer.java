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

@WebServlet(urlPatterns = { "/customer/changepassword" })
public class ChangePasswordCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	KhachHangDAO KHDao = new KhachHangDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/customer/changepassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		KhachHang KH = (KhachHang) req.getSession().getAttribute("user");
		String old_password = req.getParameter("old_password");
		String new_password = req.getParameter("new_password");
		String confirm_password = req.getParameter("confirmPassword");
		System.out.println(KH.toString());
		System.out.println(old_password);
		
		System.out.println(KH.getMK());
		HttpSession session = req.getSession();
		
		if (!KH.getMK().equals(old_password)) {
			session.setAttribute("msg", "Mật khẩu cũ không đúng!!!");
			req.getRequestDispatcher("/customer/changepassword.jsp").forward(req, resp);
		} else if (!new_password.equals(confirm_password)) {
			session.setAttribute("msg", "Mật khẩu xác nhận không đúng!!!");
			req.getRequestDispatcher("/customer/changepassword.jsp").forward(req, resp);
		} else {
			session.setAttribute("msg", "Đổi mật khẩu thành công!!!");
			KHDao.ChangePasswordCustomer(KH.getTenTK(), new_password);
			resp.sendRedirect(req.getContextPath() + "/customer/profile");

		}
	}

}
