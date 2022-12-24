package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AnhSanPhamDAO;
import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import DAO.SanPhamDAO;
import Model.AnhSanPham;
import Model.KhachHang;
import Model.SanPham;
import Model.Shop;

@WebServlet(urlPatterns = { "/vendor/home" })
public class IndexController extends HttpServlet {

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
		KhachHang vendor = (KhachHang)session.getAttribute("Vendor");
		Shop shop = (Shop)session.getAttribute("Shop");
		
		if (vendor == null && shop == null) {
			resp.sendRedirect(req.getContextPath() + "/vendor/login");
		} else {

			if(shop!=null) {
				DonHangDAO dhdao = new DonHangDAO();
				SanPhamDAO spdao = new SanPhamDAO();
				ChiTietDonHangDAO ctdhdao = new ChiTietDonHangDAO();

				String SLDH = dhdao.countOrderofShop(shop.getMaShop());

				long totalMoney = dhdao.totalMoneyOrderofShop(shop.getMaShop());
				
				String SLSP = dhdao.totalProductOrderofShop(shop.getMaShop());
				String SLKH = dhdao.countCustomerofShop(shop.getMaShop());

				req.setAttribute("SLDH", SLDH);
				req.setAttribute("totalMoney", totalMoney);
				req.setAttribute("SLSP", SLSP);
				req.setAttribute("SLKH", SLKH);

				List<String> orderbymonthofShop = new ArrayList<String>();
				List<Float> sumproducebymonthofShop = new ArrayList<Float>();
				List<Float> sumproducebypercentofShop = new ArrayList<Float>();
				
				List<Integer> topsaleproduce = new ArrayList<>();
				topsaleproduce = spdao.TopSaleProduct(shop.getMaShop());
				if(topsaleproduce!=null) {
					SanPham topproduce = spdao.getProductById(topsaleproduce.get(0));
					int toproducesale = topsaleproduce.get(1);
					AnhSanPhamDAO anhspDao = new AnhSanPhamDAO();
					List<AnhSanPham> anhspList = anhspDao.listProductImageByIdProduct(topproduce.getMaSP());
					for(AnhSanPham img : anhspList) {
						topproduce.addProductImage(img);  
					}
					
					req.setAttribute("topproduce", topproduce);
					req.setAttribute("toproducesale", toproducesale);
				}
				
			

				for (int j = 1; j <= 12; j++) {
					orderbymonthofShop.add(dhdao.countOrderOfShopByMonth(j, shop.getMaShop()));
				}
				for (int i = 0; i < 4; i++) {
					float total = 0;
					for (int j = 1; j <= 4; j++) {
						total += ctdhdao.countProduceByMonthOfShop(shop.getMaShop(), i * 3 + j);
					}
					sumproducebymonthofShop.add(total);
				}
				float total = 0;
				for (float i : sumproducebymonthofShop) {
					total += i;
				}
				for (float i : sumproducebymonthofShop) {
					sumproducebypercentofShop.add((i / total) * 100);
				}

				req.setAttribute("orderbymonthofShop", orderbymonthofShop);
				req.setAttribute("sumproducebymonthofShop", sumproducebymonthofShop);
				req.setAttribute("sumproducebypercentofShop", sumproducebypercentofShop);
			}

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
