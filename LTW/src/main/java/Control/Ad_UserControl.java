package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KhachHangDAO;
import Model.KhachHang;
import Model.Shop;

@WebServlet(urlPatterns = {"/admin/user"})
public class Ad_UserControl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        KhachHangDAO khdao =new KhachHangDAO();
        String action = request.getParameter("action");     
        String maKH = request.getParameter("maKH");
        
        if (action == null) {
            action = "";
        }
        if (action.equals("deletekh")) { 
        	khdao.deleteuser(maKH);
 
        }           
        List<KhachHang> listkh=khdao.listuser();
        
        request.setAttribute("listkh", listkh);
        request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
