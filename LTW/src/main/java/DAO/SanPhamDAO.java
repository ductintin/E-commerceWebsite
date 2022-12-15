package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.KhachHang;
import Model.SanPham;
public class SanPhamDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<SanPham> listallproduce()
    {
    	String query = "select * from SanPham where isDeleted=0";
        List<SanPham> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new SanPham(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    public List<SanPham> listproducebymaDM(String maDM)
    {
    	String query = "select * from SanPham where isDeleted=0 and maDM=?";
        List<SanPham> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maDM);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new SanPham(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    public List<SanPham> listproduceoforderdetailbymaShop(String maShop)
    {
    	String query = "select SanPham.MaSP, MaDH,TenSP,MoTa,GiaBanThuong,GiaKhuyenMai, SanPham.SoLuong,MoTaNgan,isDeleted,SoLuongDaBan,SanPham.MaShop\r\n"
    			+ "from (ChiTietDonHang inner join SanPham \r\n"
    			+ "on ChiTietDonHang.MaSP=SanPham.MaSP)\r\n"
    			+ "inner join Shop on Shop.MaShop=SanPham.MaShop\r\n"
    			+ "where Shop.MaShop=? and Shop.isDelete=0";
        List<SanPham> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maShop);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new SanPham(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    public List<SanPham> listproducebymaDH(String maDH)
    {
    	String query = "select SanPham.MaSP,MaDM,TenSP,MoTa,GiaBanThuong,GiaKhuyenMai,SanPham.SoLuong,MoTaNgan,SanPham.isDeleted,SoLuongDaBan,MaShop \r\n"
    			+ "from (ChiTietDonHang inner join DonHang \r\n"
    			+ "on ChiTietDonHang.MaDH=DonHang.MaDH)\r\n"
    			+ "inner join SanPham on SanPham.MaSP=ChiTietDonHang.MaSP\r\n"
    			+ "where ChiTietDonHang.MaDH=?";
        List<SanPham> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maDH);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new SanPham(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    public List<SanPham> listproducebymaShop(String maShop)
    {
    	String query = "select * from SanPham where isDeleted=0 and MaShop=?";
        List<SanPham> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maShop);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new SanPham(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    
    public List<SanPham> listnewproduce()
    {
    	String query = "select top(10) * from SanPham where isDeleted=0 order by MaSP desc";
        List<SanPham> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new SanPham(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    public void deleteproduce(String maSP)
    {
    	String query = "UPDATE SanPham set isDeleted= 1 where MaSP = ?";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maSP);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
    	SanPhamDAO sanPhamDAO = new SanPhamDAO();
        List<SanPham> list = sanPhamDAO.listproducebymaDH("1");
        for (SanPham o : list) {
            System.out.println(o);
        }
    }
    
}
