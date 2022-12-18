package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ChiTietDonHangDAO;
import DAO.DanhMucDAO;
import DAO.DonHangDAO;
import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import DAO.ShopDAO;
import Model.ChiTietDonHang;
import Model.DanhMuc;
import Model.KhachHang;
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
        ChiTietDonHangDAO ctdhdao=new ChiTietDonHangDAO();
        KhachHangDAO khdao=new KhachHangDAO();
        
        List<KhachHang> listkh=khdao.getuserbymaShop(maShop);
        List<ChiTietDonHang> listctdh =ctdhdao.getorderdetailbymaShop(maShop);
        String tenShop=shopdao.gettenShopbymaShop(maShop);
        List<SanPham> listsp=spdao.listproducebymaShop(maShop);
        List<SanPham> listsp1=spdao.listproduceoforderdetailbymaShop(maShop);
        
        request.setAttribute("listsp", listsp);
        request.setAttribute("listkh", listkh);
        request.setAttribute("listsp1", listsp1);
        request.setAttribute("listctdh", listctdh);
        request.setAttribute("size", listctdh.size());
        request.setAttribute("tenShop", tenShop);
        request.getRequestDispatcher("/admin/shopdetail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
