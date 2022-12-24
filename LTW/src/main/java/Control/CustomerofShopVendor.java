package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet(urlPatterns = {"/vendor/customer/list"})
public class CustomerofShopVendor extends HttpServlet{

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
		HttpSession session = req.getSession();
		
		Shop shop = (Shop) session.getAttribute("Shop");
		KhachHang vendor = (KhachHang) session.getAttribute("Vendor");
		if(vendor !=null && shop !=null  ) {
			KhachHangDAO khdao = new KhachHangDAO();
			ShopDAO shopdao = new ShopDAO();
			List<KhachHang> listkh = new ArrayList<>();
			List<Integer> listmakh = new ArrayList<Integer>();
			
			listmakh = shopdao.selectMaKhachHangofShop(shop.getMaShop());
			
			for(int i : listmakh) {
				listkh.add(khdao.getKHbyId(i));
			}
			
			req.setAttribute("listkh", listkh);
			req.getRequestDispatcher("/views/vendor/customer.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect(req.getContentType()+"/vendor/login");
		}
	}

}
