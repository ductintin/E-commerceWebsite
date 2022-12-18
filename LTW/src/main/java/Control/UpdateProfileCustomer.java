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

@WebServlet(urlPatterns = { "/customer/profile/edit" })
public class UpdateProfileCustomer extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	KhachHangDAO KHDao = new KhachHangDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		KhachHang KH = (KhachHang) req.getSession().getAttribute("user");
		req.setAttribute("KH", KH);
		req.getRequestDispatcher("/customer/editprofile.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		KhachHang KH = (KhachHang) req.getSession().getAttribute("user");
		System.out.println(Integer.valueOf(req.getParameter("MaKH")).intValue());
		System.out.println(req.getParameter("TenKH"));
		System.out.println(req.getParameter("Email"));
		System.out.println(req.getParameter("Phone"));
		System.out.println(req.getParameter("DiaChi"));
		KH.setMaKH(Integer.valueOf(req.getParameter("MaKH")).intValue());
		KH.setTenKH(req.getParameter("TenKH"));
		KH.setEmail(req.getParameter("Email"));
		KH.setPhone(req.getParameter("Phone"));
		KH.setDiaChi(req.getParameter("DiaChi"));
		KHDao.EditProfile(KH);
		HttpSession session = req.getSession();
		session.setAttribute("user", KH);
		session.setAttribute("msg", "Thay đổi thông tin thành công");
		resp.sendRedirect(req.getContextPath() + "/customer/profile");
	}

}
