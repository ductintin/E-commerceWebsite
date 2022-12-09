package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }
    
    public KhachHang create(KhachHang KH) {
    	
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
             ps.setString(7, KH.getNNMK());
             ps.setInt(8, KH.getIsVeify());
             ps.setInt(9, KH.getRole());
             ps.executeUpdate();
    		
		}catch(Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
}
