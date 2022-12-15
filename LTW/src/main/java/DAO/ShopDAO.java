package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.ConnectJDBC;
import Model.Shop;

public class ShopDAO {
	
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    KhachHangDAO KHDao = new KhachHangDAO();
    
    public void createShop(Shop shop, int maSeller) {
    	String query = "Insert into Shop (MaSeller,TenShop,PhoneShop,DiaChiShop,EmailShop,isDelete) values (?,?,?,?,?,?)";
    	
    	
    	try {
    		conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setInt(1, maSeller);
            ps.setString(2, shop.getTenShop());
            ps.setString(3, shop.getPhoneShop());
            ps.setString(4, shop.getDiaChiShop());
            ps.setString(5, shop.getEmailShop());
            ps.setInt(6, shop.getIsDeleted());
            
            ps.executeUpdate();
            
            
            
    	}catch(Exception e) {
    		System.out.print(e);
    	}
    	
    }
    
    public Shop getShopByMaSeller(int MaSeller) {
    	String query = "Select * from Shop where MaSeller = ?";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		
    		ps.setInt(1,MaSeller);
    		rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			   			
    			Shop shop = new Shop();
    			shop.setMaShop(rs.getInt(1));
    			shop.setMaSeller(rs.getInt(2));
    			shop.setTenShop(rs.getString(3));
    			shop.setPhoneShop(rs.getString(4));
    			shop.setDiaChiShop(rs.getString(5));
    			shop.setEmailShop(rs.getString(6));
    			shop.setIsDeleted(rs.getInt(7));
    			
    			return shop;
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	return null;   	
    }
    
    public String getShopNameByIdShop(int MaShop) {
    	String query = "Select TenShop from Shop where MaShop = ?";
    	
    	try {
    		conn = new ConnectJDBC().getConnection();
    		
    		ps = conn.prepareStatement(query);
    		ps.setInt(1, MaShop);
    		rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			return rs.getString(1);
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	return null;
    }
    
    
}
