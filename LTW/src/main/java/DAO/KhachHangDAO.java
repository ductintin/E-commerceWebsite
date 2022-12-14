package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.DanhMuc;
import Model.KhachHang;


public class KhachHangDAO {
	 	Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    public KhachHang login(String username, String password) {
	        String query = "select * from KhachHang\r\n"
	                + "where TenTK=? and MK = ? ";

	        try {
	            conn = new ConnectJDBC().getConnection();
	            ps = conn.prepareStatement(query);
	            ps.setString(1, username);
	            ps.setString(2, password);
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                return new KhachHang(rs.getInt(1),
	                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getString(4),
	                        rs.getString(5),
	                        rs.getString(6),
	                        rs.getString(7),
	                        rs.getInt(8),
	                        rs.getInt(9));
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        }

	        return null;
	    }
	    
	    public List<KhachHang> listuser()
	    {
	    	String query = "select * from KhachHang where (Role=4 or Role=3) and isDelete = 0";
	        List<KhachHang> list = new ArrayList<>();

	        try {
	            conn = new ConnectJDBC().getConnection();
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                 list.add(new KhachHang(rs.getInt(1),
		                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getString(4),
	                        rs.getString(5),
	                        rs.getString(6),
	                        rs.getString(7),
	                        rs.getInt(8),
	                        rs.getInt(9)));
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        }

	        return list;
	    
	    }
	    public List<KhachHang> getuserbymaKH(String maKH)
	    {
	    	String query = "select * from KhachHang where MaKH = ? and isDelete=0";
	    	List<KhachHang> list = new ArrayList<>();
	    	try {
	            conn = new ConnectJDBC().getConnection();
	            ps = conn.prepareStatement(query); 
	            ps.setString(1, maKH);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                 list.add(new KhachHang(rs.getInt(1),
		                        rs.getString(2),
	                        rs.getString(3),
	                        rs.getString(4),
	                        rs.getString(5),
	                        rs.getString(6),
	                        rs.getString(7),
	                        rs.getInt(8),
	                        rs.getInt(9)));
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        }

	        return list;
	    }
	    public void deleteuser(String maKH)
	    {
	    	String query = "UPDATE KhachHang set isDelete= 1 where MaKH = ?";
	        try {
	            conn = new ConnectJDBC().getConnection();
	            ps = conn.prepareStatement(query);
	            ps.setString(1, maKH);
	            ps.executeUpdate();
	        } catch (Exception e) {
	        }
	    }
	    public static void main(String[] args) {
	    	KhachHangDAO sanPhamDAO = new KhachHangDAO();
	        List<KhachHang> list = sanPhamDAO.listuser();
	        for (KhachHang o : list) {
	            System.out.println(o);
	        }
	    }
}
