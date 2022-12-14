package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DonHangDAO;
import DAO.KhachHangDAO;
import DAO.ShopDAO;
import Model.DonHang;
import Model.KhachHang;
import Model.Shop;

@WebServlet(urlPatterns = {"/admin/profileseller"})
public class Ad_ProfileSellerControl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        KhachHangDAO khdao= new KhachHangDAO();    
        ShopDAO shopdao =new ShopDAO();
        String maKH=request.getParameter("maSeller");     
        List<KhachHang> listkh=khdao.getuserbymaKH(maKH);
        List<Shop> listshop=shopdao.listshopbymaseller(maKH);
        
        request.setAttribute("listshop", listshop);
        request.setAttribute("listkh", listkh);
        request.getRequestDispatcher("/admin/profileseller.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
