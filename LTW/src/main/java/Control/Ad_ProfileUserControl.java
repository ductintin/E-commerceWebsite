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
@WebServlet(urlPatterns = {"/admin/profileuser"})
public class Ad_ProfileUserControl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        KhachHangDAO khdao= new KhachHangDAO();
        DonHangDAO dhdao =new DonHangDAO();
        String maKH=request.getParameter("maKH");
        List<DonHang> listdh=dhdao.listorderbymakh(maKH);
        List<KhachHang> listkh=khdao.getuserbymaKH(maKH);
        String countorder=dhdao.countorderbymaKH(maKH);
        String totalspend=dhdao.totalspendfororderbymaKH(maKH);
        String totalproduce=dhdao.totalproduceoforderbymaKH(maKH);
        
        request.setAttribute("listdh", listdh);
        request.setAttribute("size", listdh.size());
        request.setAttribute("totalproduce", totalproduce);
        request.setAttribute("totalspend", totalspend);
        request.setAttribute("countorder", countorder);
        request.setAttribute("listkh", listkh);
        request.getRequestDispatcher("/admin/profileuser.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
