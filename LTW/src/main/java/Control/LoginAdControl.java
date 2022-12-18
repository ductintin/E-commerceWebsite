package Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KhachHangDAO;
import Model.KhachHang;



@WebServlet(urlPatterns = {"/admin/loginad"})
public class LoginAdControl extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        HttpSession session = request.getSession();
        if (session.getAttribute("accad") != null) {
            response.sendRedirect("http://localhost:8080/LTW/");
        } else {
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        KhachHangDAO khdao =new KhachHangDAO();
        KhachHang a = khdao.login(username, password);
        if (a == null) {
            request.setAttribute("mess", "Sai tên đăng nhập hoặc mật khẩu");
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            int user = a.getRole();
            if (user == 1) {
                session.setAttribute("accad", a);
                response.sendRedirect("http://localhost:8080/LTW/admin/");
            } else {
                request.setAttribute("mess", "Bạn phải là Admin");
                
                request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
            }
            
        }
    }
}
