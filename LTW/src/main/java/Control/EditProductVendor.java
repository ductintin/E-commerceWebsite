package Control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.AnhSanPhamDAO;
import DAO.SanPhamDAO;
import Model.AnhSanPham;
import Model.KhachHang;
import Model.SanPham;
import Model.Shop;
import Util.Constant;

@WebServlet(urlPatterns = { "/vendor/product/edit" })
public class EditProductVendor extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
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
		KhachHang vendor = (KhachHang)session.getAttribute("Vendor");
		Shop shop = (Shop)session.getAttribute("Shop");

		try {
			SanPham sp = new SanPham();

			SanPhamDAO spDao = new SanPhamDAO();

			sp.setMaShop(shop.getMaShop());

			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {

				System.out.println(item);
				if (item.getFieldName().equals("TenSP")) {
					sp.setTenSP(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("MoTa")) {
					sp.setMoTa(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("maDM")) {
					sp.setMaDM(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("MaSP")) {
					sp.setMaSP(Integer.parseInt(item.getString("UTF-8")));
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
			
			spDao.editProductByVendor(sp);
			 
			AnhSanPhamDAO anhDao = new AnhSanPhamDAO();
			List<AnhSanPham> images = new ArrayList<>();
			
			
			for (FileItem item : items) {
				if (item.getFieldName().equals("anh1")) {
					AnhSanPham anh = new AnhSanPham();
					if(item.getSize()>0) {
						String originalFileName = item.getName();				
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/product/" + fileName);
						item.write(file);

						anh.setAnh("product/" + fileName);
						

					}else {
						anh.setAnh(null);
						anh.setMaSP(sp.getMaSP());
					}
					images.add(anh);
					
				} else if (item.getFieldName().equals("anh2")) {
					AnhSanPham anh = new AnhSanPham();
					if(item.getSize()>0) {
						String originalFileName = item.getName();						
						
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/product/" + fileName);
						item.write(file);

						anh.setAnh("product/" + fileName);
						anh.setMaSP(sp.getMaSP());
						

					}else {
						anh.setAnh(null);
						anh.setMaSP(sp.getMaSP());
					}
					images.add(anh);
				} else if (item.getFieldName().equals("anh3")) {
					AnhSanPham anh = new AnhSanPham();
					if(item.getSize()>0) {
						String originalFileName = item.getName();

						
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/product/" + fileName);
						item.write(file);


						anh.setAnh("product/" + fileName);
						anh.setMaSP(sp.getMaSP());
						

					}else {
						anh.setAnh(null);
						anh.setMaSP(sp.getMaSP());
					}
					images.add(anh);

					
				} else if (item.getFieldName().equals("anh4")) {
					AnhSanPham anh = new AnhSanPham();
					if(item.getSize()>0) {
						String originalFileName = item.getName();				
						
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/product/" + fileName);
						item.write(file);

						anh.setAnh("product/" + fileName);
						anh.setMaSP(sp.getMaSP());
						

					}else {
						anh.setAnh(null);
						anh.setMaSP(sp.getMaSP());
					}
					images.add(anh);


				}
				
				
			}
			
			anhDao.edit(images, sp.getMaSP());

			resp.sendRedirect(req.getContextPath() + "/vendor/product/list");

		}
		catch (FileUploadException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Lỗi trong EditVendor:"+e);

		}
	}

}
