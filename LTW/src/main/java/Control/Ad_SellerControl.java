package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KhachHangDAO;
import DAO.ShopDAO;
import Model.KhachHang;
import Model.Shop;

@WebServlet(urlPatterns = {"/admin/seller"})
public class Ad_SellerControl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        ShopDAO shopdao=new ShopDAO();
        List<Shop> listshop=shopdao.listshop();
        request.setAttribute("listshop", listshop);
        request.getRequestDispatcher("/admin/seller.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
