package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AnhSanPhamDAO;
import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import Model.AnhSanPham;
import Model.DanhMuc;
import Model.SanPham;

@WebServlet(urlPatterns = { "/home" })
public class HomeControllerCustomer extends HttpServlet {

	/**
	 * 
	 */
	SanPhamDAO sanphamDao = new SanPhamDAO();
	DanhMucDAO danhmucDao = new DanhMucDAO();
	AnhSanPhamDAO anhsanphamDao = new AnhSanPhamDAO();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int b = 1;
		if (req.getSession(false) == null)
			b = 0;
		List<DanhMuc> listdm = danhmucDao.getallDanhMuc();

		for (DanhMuc dm : listdm) {
			List<SanPham> spList = sanphamDao.listproducebymaDM(String.valueOf(dm.getMaDM()));

			for (SanPham sp : spList) {
				dm.addProduct(sp);
				List<AnhSanPham> anhspList = anhsanphamDao.listProductImageByIdProduct(sp.getMaSP());
				for (AnhSanPham img : anhspList) {
					sp.addProductImage(img);

				}

			}

		}

		req.setAttribute("danhmucList", listdm);
		req.setAttribute("logged", b);
		req.getRequestDispatcher("/customer/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}