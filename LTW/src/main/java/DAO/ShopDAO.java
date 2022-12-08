package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.DanhMuc;
import Model.KhachHang;
import Model.Shop;

public class ShopDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Shop> listshop()
    {
    	String query = "select * from Shop";
        List<Shop> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new Shop(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
                       
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return list;
    
    }
    public static void main(String[] args) {
    	ShopDAO sanPhamDAO = new ShopDAO();
        List<Shop> list = sanPhamDAO.listshop();
        for (Shop o : list) {
            System.out.println(o);
        }
    }

}
