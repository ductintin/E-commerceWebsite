package DAO;

import java.sql.*;
import java.util.*;

import Connection.ConnectJDBC;
import Model.DanhMuc;

public class DanhMucDAO {
	
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<DanhMuc> getallDanhMuc() {
    	List<DanhMuc> list=new ArrayList<>();
        String query = "select * from DanhMuc";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);          
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new DanhMuc( rs.getInt(1),
            			rs.getString(2),
            			rs.getInt(3)));
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        return list;
    }
}
