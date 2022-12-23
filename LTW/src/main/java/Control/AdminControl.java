package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import DAO.KhachHangDAO;
import DAO.SanPhamDAO;
import DAO.ShopDAO;



@WebServlet(urlPatterns = {"/admin/"})
public class AdminControl extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
       
        if (session.getAttribute("accad") == null) {
            response.sendRedirect("http://localhost:8080/LTW/admin/loginad");
        }
        else {
        	List<String> orderbymonth = new ArrayList<String>();
        	List<Float> sumproducebymonth = new ArrayList<Float>();
        	List<Float> sumproducebypercent = new ArrayList<Float>();
        	DonHangDAO dhdao = new DonHangDAO();
    		KhachHangDAO khdao = new KhachHangDAO();
    		ShopDAO shopdao = new ShopDAO();
    		SanPhamDAO spdao = new SanPhamDAO();
    		ChiTietDonHangDAO ctspdao= new ChiTietDonHangDAO();

    		String countproduce = spdao.countuserbymounth();
    		String countproduceofshop = shopdao.countproduceofshopbymounth();
    		String countorderofshop = shopdao.countorderofshopbymounth();
    		String userofmonth = khdao.userofmounth();
    		String countorderofuser = khdao.orderofuserbymounth();
    		String countorder = dhdao.countorderbymounth();
    		String tenshopofshop=shopdao.tenshopofshopbymounth();
    		
    		for (int j = 1; j <= 12; j++) {
    			orderbymonth.add(dhdao.countOrderByMonth(j));
    		}
    		for (int i = 0; i < 4; i++) {
    			float total=0;
    			for (int j = 1; j <= 4; j++)
    			{
    				total+=ctspdao.countProduceByMonth(i*3+j);
    			}
    			sumproducebymonth.add(total);		
    		}
    		float total=0;
    		for (float i : sumproducebymonth) {
    			total+=i;		
    		}
    		for (float i : sumproducebymonth) {
    			sumproducebypercent.add( (i/total)*100);		
    		}
     	
    		 request.setAttribute("countproduceofshop", countproduceofshop);
    		 request.setAttribute("tenshopofshop", tenshopofshop);
    		 request.setAttribute("countorderofshop", countorderofshop);
    		 request.setAttribute("sumproducebypercent", sumproducebypercent);
    		 request.setAttribute("orderbymonth", orderbymonth);
    		request.setAttribute("countproduce", countproduce);
    		request.setAttribute("countorderofuser", countorderofuser);
    		request.setAttribute("userofmonth", userofmonth);
    		request.setAttribute("countorder", countorder);
    		request.getRequestDispatcher("/admin/index.jsp").forward(request, response); 
        }
          
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);

    }

	
}
