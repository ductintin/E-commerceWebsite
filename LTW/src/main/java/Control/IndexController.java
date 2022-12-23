package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DonHangDAO;
import Model.KhachHang;
import Model.Shop;

@WebServlet(urlPatterns = { "/vendor/home" })
public class IndexController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("Vendor");
		if(obj == null) {
			resp.sendRedirect(req.getContextPath() + "/vendor/login");
		}
		else {
			KhachHang vendor = (KhachHang) session.getAttribute("Vendor");
			Shop shop = (Shop) session.getAttribute("Shop");
			DonHangDAO dhDao = new DonHangDAO();
			String SLDH = dhDao.countOrderofShop(shop.getMaShop());
			
			String totalMoney = dhDao.totalMoneyOrderofShop(shop.getMaShop());
			String SLSP = dhDao.totalProductOrderofShop(shop.getMaShop());
			String SLKH = dhDao.countCustomerofShop(shop.getMaShop());
			
			req.setAttribute("SLDH", SLDH);
			req.setAttribute("totalMoney", totalMoney);
			req.setAttribute("SLSP", SLSP);
			req.setAttribute("SLKH", SLKH);
			
			System.out.println(totalMoney);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/home.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 super.doPost(req, resp); 
				
		
	}

}
