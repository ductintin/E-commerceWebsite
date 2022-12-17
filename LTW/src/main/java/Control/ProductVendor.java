package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import Model.DanhMuc;
import Model.KhachHang;
import Model.SanPham;
import Model.Shop;

@WebServlet(urlPatterns = {"/vendor/product/list"})
public class ProductVendor extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	SanPhamDAO spDao = new SanPhamDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = req.getSession();
		
		Shop shop = (Shop)session.getAttribute("Shop");
		KhachHang vendor = (KhachHang)session.getAttribute("Vendor");
		System.out.println("MaShop trong ProductVendor" + shop.getMaShop());			
		System.out.println("Ma NG Ban trong ProductVendor" + vendor.getMaKH());
		
		DanhMucDAO dmdao = new DanhMucDAO();

		List<DanhMuc> listdm = dmdao.getallDanhMuc();

		
		
		req.setAttribute("listdm", listdm);
		List<SanPham> spList = spDao.listproducebymaShop("x");
		req.setAttribute("spList", spList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/list-product.jsp");
		dispatcher.forward(req, resp);
	}

}
