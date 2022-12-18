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

@WebServlet(urlPatterns = { "/customer/login" })
public class LoginCustomer extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/login.jsp");
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

		String destPage = "/customer/login.jsp";
		try {
			KH = KHDao.login(accountName, password);

			System.out.print(KH);
			if (KH.equals(null) == false && KH.getRole() == 3) {
				HttpSession session = req.getSession();
				req.setAttribute("msg", "");
				session.setAttribute("user", KH);
				resp.sendRedirect(req.getContextPath() + "/");
			} else {
				String msg = "Tài khoản không hợp lệ";
				req.setAttribute("msg", msg);
				req.setAttribute("KH", KH);
				RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
				dispatcher.forward(req, resp);
			}

		} catch (Exception e) {
			System.out.print(e);
		}

	}
}