package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AnhSanPhamDAO;
import DAO.SanPhamDAO;
import Model.AnhSanPham;
import Model.SanPham;

@WebServlet(urlPatterns = "/product")
public class ProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SanPhamDAO sanphamDao = new SanPhamDAO();
	AnhSanPhamDAO anhsanphamDao = new AnhSanPhamDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		SanPham sanpham = sanphamDao.getProductById(id);
		List<AnhSanPham> listAnhSanPham = anhsanphamDao.listProductImageByIdProduct(sanpham.getMaSP());
		req.setAttribute("listimage", listAnhSanPham);
		req.setAttribute("product", sanpham);
		req.getRequestDispatcher("/customer/product.jsp").forward(req, resp);
	}

}
