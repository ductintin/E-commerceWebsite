package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ChiTietDonHangDAO;
import DAO.TrangThaiDAO;
import Model.ChiTietDonHang;
import Model.TrangThai;

@WebServlet(urlPatterns = {"/vendor/order/detail"})
public class OrderDetailVendor extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
		
		String maDH = req.getParameter("maDH");
		String action = req.getParameter("action");
		
		System.out.println(action +"ne");
		String maCTDH = req.getParameter("maCTDH");
		
		ChiTietDonHangDAO ctdhDao = new ChiTietDonHangDAO();
		if(action !=null) {
			if(action.equals("confirm")) {
				ctdhDao.confirmCTDH(maCTDH, 2);
			}
			
			if(action.equals("delivery")) {
				ctdhDao.confirmCTDH(maCTDH, 3);
			}
		}
		List<ChiTietDonHang> listctdh = ctdhDao.getorderdetailbymaDH(maDH);
		
		
		req.setAttribute("listctdh", listctdh);
        
        req.setAttribute("size", listctdh.size());
        req.getRequestDispatcher("/views/vendor/orderdetail.jsp").forward(req, resp);
        
        //resp.sendRedirect(req.getContextPath() + "/vendor/order/detail");
        
        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}

