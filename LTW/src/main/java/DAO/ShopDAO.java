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
    	String query = "select * from Shop where isDelete=0";
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
                        rs.getString(6),
                        rs.getInt(7)));
                       
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return list;
    
    }
    public List<Shop> listshopbymaseller(String maSeller)
    {
    	String query = "select * from Shop where isDelete=0 and maSeller=?";
        List<Shop> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maSeller);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new Shop(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
                       
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return list;
    
    }
    public List<Shop> listshopbymaDH(String maDH)
    {
    	String query = "select Shop.MaShop,MaSeller,TenShop,PhoneShop,DiaChiShop,EmailShop,Shop.isDelete \r\n"
    			+ "from ((ChiTietDonHang inner join DonHang \r\n"
    			+ "on ChiTietDonHang.MaDH=DonHang.MaDH)\r\n"
    			+ "inner join SanPham on SanPham.MaSP=ChiTietDonHang.MaSP)\r\n"
    			+ "inner join Shop on Shop.MaShop=SanPham.MaShop\r\n"
    			+ "where ChiTietDonHang.MaDH=?";
        List<Shop> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maDH);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new Shop(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
                       
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return list;
    
    }
    public String gettenShopbymaShop(String maShop)
    {
    	String query = "select TenShop from Shop where MaShop = ? and isDelete=0";
    	String tenShop = null;
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query); 
            ps.setString(1, maShop);
            rs = ps.executeQuery();
            while (rs.next()) {
            	tenShop=rs.getString(1);
            			
            }
            return tenShop;
        } catch (Exception e) {
            // TODO: handle exception
        }
		return tenShop;
    }
    public void deleteshop(String maShop)
    {
    	String query = "UPDATE Shop set isDelete= 1 where MaShop = ?";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maShop);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public String countorderofshopbymounth()
    {
    	String query = "select top(1) count(DonHang.MaDH) as TongDH, sum(ChiTietDonHang.SoLuong) from SanPham\r\n"
    			+ "inner join ChiTietDonHang on ChiTietDonHang.MaSP =SanPham.MaSP\r\n"
    			+ "inner join Shop on Shop.MaShop = SanPham.MaShop\r\n"
    			+ "inner join DonHang on DonHang.MaDH=ChiTietDonHang.MaDH\r\n"
    			+ "where DonHang.isDeleted=0 and MONTH(ThoiGian)=MONTH(GETDATE())\r\n"
    			+ "ORDER BY TongDH DESC ";
    	String countorderofshop = null;
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);         
            rs = ps.executeQuery();
            while (rs.next()) {
            	countorderofshop=rs.getString(1);
            			
            }
            return countorderofshop;
        } catch (Exception e) {
            // TODO: handle exception
        }
		return countorderofshop;
    }
    public String countproduceofshopbymounth()
    {
    	String query = "select top(1) count(DonHang.MaDH) as TongDH, sum(ChiTietDonHang.SoLuong) from SanPham\r\n"
    			+ "inner join ChiTietDonHang on ChiTietDonHang.MaSP =SanPham.MaSP\r\n"
    			+ "inner join Shop on Shop.MaShop = SanPham.MaShop\r\n"
    			+ "inner join DonHang on DonHang.MaDH=ChiTietDonHang.MaDH\r\n"
    			+ "where DonHang.isDeleted=0 and MONTH(ThoiGian)=MONTH(GETDATE())\r\n"
    			+ "ORDER BY TongDH DESC ";
    	String countproduceofshop = null;
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);         
            rs = ps.executeQuery();
            while (rs.next()) {
            	countproduceofshop=rs.getString(2);
            			
            }
            return countproduceofshop;
        } catch (Exception e) {
            // TODO: handle exception
        }
		return countproduceofshop;
    }
    public String tenshopofshopbymounth()
    {
    	String query = "select top(1) TenShop,count(DonHang.MaDH) as TongDH from SanPham\r\n"
    			+ "inner join ChiTietDonHang on ChiTietDonHang.MaSP =SanPham.MaSP\r\n"
    			+ "inner join Shop on Shop.MaShop = SanPham.MaShop\r\n"
    			+ "inner join DonHang on DonHang.MaDH=ChiTietDonHang.MaDH\r\n"
    			+ "where DonHang.isDeleted=0 and MONTH(ThoiGian)=MONTH(GETDATE())\r\n"
    			+ "Group by TenShop\r\n"
    			+ "ORDER BY TongDH DESC\r\n"
    			+ " ";
    	String tenshopofshop = null;
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);         
            rs = ps.executeQuery();
            while (rs.next()) {
            	tenshopofshop=rs.getString(1);
            			
            }
            return tenshopofshop;
        } catch (Exception e) {
            // TODO: handle exception
        }
		return tenshopofshop;
    }
    public static void main(String[] args) {
    	ShopDAO sanPhamDAO = new ShopDAO();
        List<Shop> list = sanPhamDAO.listshopbymaDH("2");
        for (Shop o : list) {
            System.out.println(o);
//    	String tenDM=sanPhamDAO.gettenShopbymaShop("1");
//        System.out.println(tenDM);
        }
    }
}

