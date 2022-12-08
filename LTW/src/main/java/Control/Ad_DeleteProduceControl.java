package Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DanhMucDAO;
import DAO.SanPhamDAO;

@WebServlet(urlPatterns = {"/admin/deleteproduce"})
public class Ad_DeleteProduceControl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String action = request.getParameter("action");            
        String maSP = request.getParameter("maSP");       
        SanPhamDAO spdao=new SanPhamDAO();
            
        if (action == null) {
            action = "";
        }
        if (action.equals("deletesp")) { 
            spdao.deleteproduce(maSP);
            response.sendRedirect("http://localhost:8080/LTW/admin/allproduce");
        }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
