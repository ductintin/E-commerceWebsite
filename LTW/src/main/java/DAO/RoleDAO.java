package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.ConnectJDBC;
import Model.Role;

public class RoleDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
	public Role getRoleById(int id) {
		String query = "select * from Role where id = ?";
		try {
			conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);          
            rs = ps.executeQuery();
            
            while(rs.next()) {
            	return new Role(rs.getInt(1), rs.getString(2));
            }
		}
		catch(Exception e){
			
		}
		
		return null;
	}
}
