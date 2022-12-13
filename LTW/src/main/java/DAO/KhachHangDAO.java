package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import Connection.ConnectJDBC;
import Model.KhachHang;


import org.mindrot.jbcrypt.BCrypt;
public class KhachHangDAO {
	
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    RoleDAO roleDao;
    public KhachHang login(String username, String password) {
        String query = "select * from KhachHang\r\n"
                + "where TenTK=? and MK = ?";

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
    
    public KhachHang createVendor(KhachHang KH) {
    	
    	try {
    		conn = new ConnectJDBC().getConnection();
			/*
			 * KH.setMK(BCrypt.hashpw(KH.getMK(), BCrypt.gensalt(4))); KH.setRole(2);
			 * String[] email = KH.getEmail().split("@"); KH.setEmail(email[0] + "+" +
			 * BCrypt.hashpw("", BCrypt.gensalt(4)) + "@" + email[1]); return KH;
			 */
    		
    		String query = "Insert into KhachHang values(?,?,?,?,?,?,?,?,?)";
    		 ps = conn.prepareStatement(query);
    		 ps.setString(1, KH.getTenKH());
             ps.setString(2, KH.getTenTK());
             ps.setString(3, KH.getMK());
             ps.setString(4, KH.getEmail());
             ps.setString(5, KH.getPhone());
             ps.setString(6, KH.getDiaChi());
             ps.setInt(7, KH.getRole());
             ps.setInt(8, KH.getIsDeleted());
             ps.executeUpdate();
    		
		}catch(Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    
    public List<KhachHang> listVendor()
    {
    	String query = "select * from KhachHang where Role=3";
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
    
    public KhachHang findVendorByAccountName(String accountName) {
    	try {
    		conn = new ConnectJDBC().getConnection();
    		String sql = "Select * from KhachHang where Role = 3 and TenTK = ?";
    		ps = conn.prepareStatement(sql);
    		ps.setString(1, accountName);
            rs = ps.executeQuery();
            
            while(rs.next()) {
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
    	}catch(Exception e) {
    		
    	}
    	
    	return null;
    }
}
