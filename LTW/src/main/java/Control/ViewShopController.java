package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDAO;
import DAO.ShopDAO;
import Model.SanPham;

@WebServlet(urlPatterns = "/shop/viewshop")
public class ViewShopController extends HttpServlet {

	SanPhamDAO sanphamDao = new SanPhamDAO();
	ShopDAO shopDao = new ShopDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		List<SanPham> sanphamList = sanphamDao.listproducebymaShop(id);
		String shop = shopDao.gettenShopbymaShop(id);
		req.setAttribute("productList", sanphamList);
		req.setAttribute("nameShop", shop);
		req.getRequestDispatcher("/customer/viewshop.jsp").forward(req, resp);
	}

}
