package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import DAO.TrangThaiDAO;
import Model.ChiTietDonHang;
import Model.DonHang;
import Model.KhachHang;
import Model.Shop;
import Model.TrangThai;


@WebServlet(urlPatterns = {"/vendor/order/list"})
public class AllOrdersVendor extends HttpServlet{

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
        HttpSession session = req.getSession();
        
		Shop shop = (Shop) session.getAttribute("Shop");
		

		
		DonHangDAO dhdao=new DonHangDAO();

	    TrangThaiDAO ttdao=new TrangThaiDAO();
	    
	    //List<ChiTietDonHang> listdh = ctdao.getorderdetailbymaShop(Integer.toString(shop.getMaShop()));
	    List<DonHang> listdh = dhdao.listallorderbyMaShop(shop.getMaShop());
        List<TrangThai> listtt =ttdao.listtrangthai();
        
        req.setAttribute("listdh", listdh);

        req.setAttribute("listtt", listtt);
        req.setAttribute("size", listdh.size());
        req.getRequestDispatcher("/views/vendor/allorders.jsp").forward(req, resp);
	     
	     
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	


}
