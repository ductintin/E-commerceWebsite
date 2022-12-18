package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DonHangDAO;
import DAO.SanPhamDAO;
import DAO.TrangThaiDAO;
import Model.DonHang;
import Model.SanPham;
import Model.TrangThai;

@WebServlet(urlPatterns = {"/admin/allorder"})
public class Ad_AllOrderControl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String action = request.getParameter("action");            
        String maDH = request.getParameter("maDH");       
        DonHangDAO dhdao=new DonHangDAO();
        TrangThaiDAO ttdao=new TrangThaiDAO();
            
        if (action == null) {
            action = "";
        }
        if (action.equals("deletedh")) { 
            dhdao.deleteorder(maDH);
         //   response.sendRedirect("http://localhost:8080/LTW/admin/allproduce");
        }      
        
        List<DonHang> listdh = dhdao.listallorder();
        List<TrangThai> listtt =ttdao.listtrangthai();
       
        
        request.setAttribute("listdh", listdh);
        
        request.setAttribute("listtt", listtt);
        request.setAttribute("size", listdh.size());
        request.getRequestDispatcher("/admin/allorder.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}