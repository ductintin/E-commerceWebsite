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

import DAO.AnhSanPhamDAO;
import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import Model.AnhSanPham;
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
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = req.getSession();
		
		Shop shop = (Shop)session.getAttribute("Shop");
		KhachHang vendor = (KhachHang)session.getAttribute("Vendor");
		System.out.println("Ma shop o day ne"+shop.getMaShop());
		
		String maSP = req.getParameter("maSP");
		String action = req.getParameter("action");
		
		
		
		DanhMucDAO dmdao = new DanhMucDAO();
		SanPhamDAO spDao = new SanPhamDAO();
		AnhSanPhamDAO anhspDao = new AnhSanPhamDAO();
		
		if(action !=null) {
			if(action.equals("restore")) {
				spDao.restoreProduct(maSP);
			}
		}
		List<DanhMuc> listdm = dmdao.getallDanhMuc();

		
		for(DanhMuc dm : listdm) {
			List<SanPham> spList = spDao.listproducebymaDMandMaShop(String.valueOf(dm.getMaDM()),shop.getMaShop());
			
			System.out.println("Sp list lay ne" +spList +"splist");
			for(SanPham sp : spList) {
				dm.addProduct(sp);
				List<AnhSanPham> anhspList = anhspDao.listProductImageByIdProduct(sp.getMaSP());
				for(AnhSanPham img : anhspList) {
					sp.addProductImage(img);
					
				}
				
			}
			System.out.println(dm.getProducts());
		}
		
		req.setAttribute("listdm", listdm);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/list-product.jsp");
		dispatcher.forward(req, resp);
	}

}
