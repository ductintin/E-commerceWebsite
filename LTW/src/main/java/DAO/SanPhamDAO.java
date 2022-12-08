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
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)));
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
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)));
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
        List<SanPham> list = sanPhamDAO.listnewproduce();
        for (SanPham o : list) {
            System.out.println(o);
        }
    }
    
}
