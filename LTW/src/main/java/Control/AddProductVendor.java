package Control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.AnhSanPhamDAO;
import DAO.DanhMucDAO;
import DAO.SanPhamDAO;
import Model.AnhSanPham;
import Model.DanhMuc;
import Model.KhachHang;
import Model.SanPham;
import Model.Shop;
import Util.Constant;

@WebServlet(urlPatterns = { "/vendor/product/add" })
public class AddProductVendor extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* super.doGet(req, resp); */

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/add-product.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		

		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");

		
		HttpSession session = req.getSession();
		KhachHang vendor = (KhachHang) session.getAttribute("Vendor");
		Shop shop = (Shop) session.getAttribute("Shop");
		

		try {
			SanPham sp = new SanPham();
			SanPhamDAO spDao = new SanPhamDAO();
			
			int spIndex = spDao.getLastIndexOfProduct() + 1;
			
			sp.setMaShop(shop.getMaShop());
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				
				
				System.out.println(item);
				if (item.getFieldName().equals("TenSP")) {
					sp.setTenSP(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("MoTa")) {
					sp.setMoTa(item.getString("UTF-8"));
					/*
					 * } else if (item.getFieldName().equals("shop")) {
					 * sp.setMaShop(Integer.parseInt(item.getString("UTF-8")));
					 * System.out.println("Mã cửa hàng nè"+Integer.parseInt(item.getString("UTF-8"))
					 * );
					 */
				} else if (item.getFieldName().equals("maDM")) {
					sp.setMaDM(Integer.parseInt(item.getString("UTF-8")));
					System.out.println("Mã danh mục nè"+Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("Gia")) {
					sp.setGiaBanThuong(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("KhuyenMai")) {
					sp.setGiaKhuyenMai(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("SoLuongKho")) {
					sp.setSoLuong(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("MoTaNgan")) {
					sp.setMoTaNgan(item.getString("UTF-8"));
				} 
			}
			
			spDao.createProductByVendor(sp);
			
			for (FileItem item : items) {
				 if (item.getFieldName().equals("anh1")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/product/" + fileName);
					item.write(file);

					AnhSanPham anh = new AnhSanPham();
					AnhSanPhamDAO anhDao = new AnhSanPhamDAO();
					
					anh.setMaSP(spIndex);
					anh.setAnh("product/" + fileName);

					anhDao.addProductImageByVendor(anh);
				} else if (item.getFieldName().equals("anh2")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/product/" + fileName);
					item.write(file);

					AnhSanPham anh = new AnhSanPham();
					AnhSanPhamDAO anhDao = new AnhSanPhamDAO();
					anh.setMaSP(spIndex);
					anh.setAnh("product/" + fileName);

					anhDao.addProductImageByVendor(anh);
				} else if (item.getFieldName().equals("anh3")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/product/" + fileName);
					item.write(file);

					AnhSanPham anh = new AnhSanPham();
					AnhSanPhamDAO anhDao = new AnhSanPhamDAO();
					anh.setMaSP(spIndex);
					anh.setAnh("product/" + fileName);

					anhDao.addProductImageByVendor(anh);
				} else if (item.getFieldName().equals("anh4")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/product/" + fileName);
					item.write(file);

					AnhSanPham anh = new AnhSanPham();
					AnhSanPhamDAO anhDao = new AnhSanPhamDAO();
					anh.setMaSP(spIndex);
					anh.setAnh("product/" + fileName);

					anhDao.addProductImageByVendor(anh);
					
					System.out.println(anh);
				}
			}

			resp.sendRedirect(req.getContextPath() + "/vendor/product/list");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
