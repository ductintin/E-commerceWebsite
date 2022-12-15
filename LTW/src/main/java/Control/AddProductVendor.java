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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DAO.AnhSanPhamDAO;
import DAO.DanhMucDAO;
import Model.AnhSanPham;
import Model.DanhMuc;
import Model.SanPham;
import Util.Constant;

@WebServlet(urlPatterns = {"/vendor/product/add"})
public class AddProductVendor extends HttpServlet{

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
        
        DanhMucDAO dmdao= new DanhMucDAO();
		
		List<DanhMuc> listdm =dmdao.getallDanhMuc();
		
		String maKH = req.getParameter("Vendor");
		System.out.println("MaKH AS"+ maKH);
		req.setAttribute("listdm", listdm);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/add-product.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        
        SanPham sp = new SanPham();
        
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		
		try {
			
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				
				
				if (item.getFieldName().equals("TenSP")) {
					sp.setTenSP(item.getString("UTF-8"));
				} 
				else if(item.getFieldName().equals("TenSP")){
					
				}
				else if(item.getFieldName().equals("MoTa")){
					
				}
				else if(item.getFieldName().equals("Gia")){
					
				}
				else if(item.getFieldName().equals("KhuyenMai")){
					
				}
				else if(item.getFieldName().equals("SoLuongKho")){
					
				}
				else if(item.getFieldName().equals("MoTaNgan")){
					
				}
				else if (item.getFieldName().equals("anh1")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/category/" + fileName);
					item.write(file);
					
					AnhSanPham anh = new AnhSanPham();
					AnhSanPhamDAO anhDao = new AnhSanPhamDAO();
					anh.setAnh("product/" + fileName);
					anh.createAnh();
				}
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
