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
import Model.DanhMuc;

@WebServlet(urlPatterns = {"/admin/addcategory"})
public class Ad_AddCategoryControl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String action = request.getParameter("action");     
        String maDM = request.getParameter("maDM");
        DanhMucDAO dmdao= new DanhMucDAO();     
        
        if (action == null) {
            action = "";
        }
        if (action.equals("delete")) { 
            dmdao.deletecategory(maDM);
          //  response.sendRedirect("http://localhost:8080/LTW/admin/category");
        }      
        request.getRequestDispatcher("/admin/addcategory.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        DanhMucDAO dmdao = new DanhMucDAO();
        //String maDM = request.getParameter("maDM");
        String tenDM = request.getParameter("tenDM");
        //if (maDM.equals("") || maDM == null || maDM.equals("0")) {
            dmdao.createcategory(tenDM);
        //}
        response.sendRedirect("http://localhost:8080/LTW/admin/category");
	}

}
