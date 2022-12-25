package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ShopDAO;
import Model.Shop;

@WebServlet(urlPatterns = "/shop")
public class ShopController extends HttpServlet {

	ShopDAO shopDao = new ShopDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Shop> shop = shopDao.listshop();
		req.setAttribute("shopList", shop);
		req.getRequestDispatcher("/customer/shop.jsp").forward(req, resp);
	}

}
