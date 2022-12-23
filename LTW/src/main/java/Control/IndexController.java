package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import DAO.SanPhamDAO;
import Model.KhachHang;
import Model.Shop;

@WebServlet(urlPatterns = { "/vendor/home" })
public class IndexController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("Vendor");
		if(obj == null) {
			resp.sendRedirect(req.getContextPath() + "/vendor/login");
		}
		else {
			KhachHang vendor = (KhachHang) session.getAttribute("Vendor");
			Shop shop = (Shop) session.getAttribute("Shop");
			
			DonHangDAO dhdao = new DonHangDAO();
			SanPhamDAO spdao = new SanPhamDAO();
    		ChiTietDonHangDAO ctdhdao= new ChiTietDonHangDAO();
			
			String SLDH = dhdao.countOrderofShop(shop.getMaShop());
			
			String totalMoney = dhdao.totalMoneyOrderofShop(shop.getMaShop());
			String SLSP = dhdao.totalProductOrderofShop(shop.getMaShop());
			String SLKH = dhdao.countCustomerofShop(shop.getMaShop());
			
			req.setAttribute("SLDH", SLDH);
			req.setAttribute("totalMoney", totalMoney);
			req.setAttribute("SLSP", SLSP);
			req.setAttribute("SLKH", SLKH);
			
			List<String> orderbymonthofShop = new ArrayList<String>();
        	List<Float> sumproducebymonthofShop = new ArrayList<Float>();
        	List<Float> sumproducebypercentofShop = new ArrayList<Float>();
        	
        	for (int j = 1; j <= 12; j++) {
    			orderbymonthofShop.add(dhdao.countOrderOfShopByMonth(j,shop.getMaShop()));
    		}
    		for (int i = 0; i < 4; i++) {
    			float total=0;
    			for (int j = 1; j <= 4; j++)
    			{
    				total+=ctdhdao.countProduceByMonthOfShop(shop.getMaShop(),i*3+j);
    			}
    			sumproducebymonthofShop.add(total);		
    		}
    		float total=0;
    		for (float i : sumproducebymonthofShop) {
    			total+=i;		
    		}
    		for (float i : sumproducebymonthofShop) {
    			sumproducebypercentofShop.add( (i/total)*100);		
    		}
        	
        	req.setAttribute("orderbymonthofShop", orderbymonthofShop);
        	req.setAttribute("sumproducebymonthofShop", sumproducebymonthofShop);
    		req.setAttribute("sumproducebypercentofShop", sumproducebypercentofShop);
			
			System.out.println(totalMoney);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/home.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 super.doPost(req, resp); 
				
		
	}

}
