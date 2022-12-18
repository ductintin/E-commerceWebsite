package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DonHangDAO;
import Model.DonHang;

@WebServlet(urlPatterns = {"/admin/neworder"})
public class Ad_NewOrderControl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String action = request.getParameter("action");            
        String maDH = request.getParameter("maDH");       
        DonHangDAO dhdao=new DonHangDAO();
            
        if (action == null) {
            action = "";
        }
        if (action.equals("deletedh")) { 
            dhdao.deleteorder(maDH);
       
        }      
        List<DonHang> listdh = dhdao.listneworder();
        
        request.setAttribute("listdh", listdh);
        request.getRequestDispatcher("/admin/neworder.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
