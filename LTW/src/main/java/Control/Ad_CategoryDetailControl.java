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
import Model.SanPham;

@WebServlet(urlPatterns = {"/admin/categorydetail"})
public class Ad_CategoryDetailControl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String maDM= request.getParameter("maDM");
        SanPhamDAO spdao=new SanPhamDAO();
        List<SanPham> listsp=spdao.listproducebymaDM(maDM);
        DanhMucDAO dmdao=new DanhMucDAO();
        String tenDM=dmdao.gettenDMbymaDM(maDM);
        
        request.setAttribute("listsp", listsp);
        request.setAttribute("tenDM", tenDM);
        request.getRequestDispatcher("/admin/categorydetail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
