package Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.KhachHang;

@WebServlet(urlPatterns = { "/customer/profile" })
public class ProfileCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		KhachHang KH = (KhachHang) session.getAttribute("user");
		String msg = (String) session.getAttribute("msg");
		req.setAttribute("msg", msg);
		session.setAttribute("msg", "");
		req.setAttribute("KH", KH);
		req.getRequestDispatcher("/customer/profile.jsp").forward(req, resp);
	}
}
