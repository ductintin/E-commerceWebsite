package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import DAO.ShopDAO;
import DAO.TrangThaiDAO;
import Model.ChiTietDonHang;
import Model.DonHang;
import Model.KhachHang;
import Model.SanPham;
import Model.Shop;
import Model.TrangThai;

@WebServlet(urlPatterns = {"/admin/orderdetail"})
public class Ad_OrderDetailControl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
               
        String maDH = request.getParameter("maDH"); 
        String maKH = request.getParameter("maKH"); 
        DonHangDAO dhdao=new DonHangDAO();  
        ChiTietDonHangDAO ctdhdao=new ChiTietDonHangDAO();
        KhachHangDAO khdao= new KhachHangDAO();
        SanPhamDAO spdao=new SanPhamDAO();
        ShopDAO shopdao=new ShopDAO();
        TrangThaiDAO ttdao=new TrangThaiDAO();
        
        List<Shop> listshop=shopdao.listshopbymaDH(maDH);
        List<SanPham> listsp=spdao.listproducebymaDH(maDH);
        List<KhachHang> listkh=khdao.getuserbymaKH(maKH);
        List<ChiTietDonHang> listctdh=ctdhdao.getorderdetailbymaDH(maDH);
        List<DonHang> listdh = dhdao.listallorderbymaDH(maDH);
        List<TrangThai> listtt =ttdao.listtrangthai();
        
        request.setAttribute("listtt", listtt);
        request.setAttribute("listctdh", listctdh);
        request.setAttribute("listshop", listshop);
        request.setAttribute("listsp", listsp);
        request.setAttribute("listkh", listkh);
        request.setAttribute("size", listctdh.size());
        request.setAttribute("listdh", listdh);
        request.getRequestDispatcher("/admin/orderdetail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
