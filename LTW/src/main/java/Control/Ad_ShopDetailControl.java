package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import DAO.ShopDAO;
import Model.DanhMuc;
import Model.SanPham;

@WebServlet(urlPatterns = {"/admin/shopdetail"})
public class Ad_ShopDetailControl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String maShop = request.getParameter("maShop");
        SanPhamDAO spdao=new SanPhamDAO();
        ShopDAO shopdao=new ShopDAO();
        String tenShop=shopdao.gettenShopbymaShop(maShop);
        List<SanPham> listsp=spdao.listproducebymaShop(maShop);
        
        request.setAttribute("listsp", listsp);
        request.setAttribute("tenShop", tenShop);
        request.getRequestDispatcher("/admin/shopdetail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
