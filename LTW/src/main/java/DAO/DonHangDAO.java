package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.DonHang;
import Model.SanPham;

public class DonHangDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<DonHang> listallorder()
    {
    	String query = "select * from DonHang where isDeleted=0";
        List<DonHang> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new DonHang(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    
    public List<DonHang> listneworder()
    {
    	String query = "select top(10) * from DonHang where isDeleted=0 order by MaDH desc";
        List<DonHang> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new DonHang(rs.getInt(1),
                		 rs.getInt(2),
                         rs.getInt(3),
                         rs.getDate(4),
                         rs.getInt(5)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    public void deleteorder(String maDH)
    {
    	String query = "UPDATE DonHang set isDeleted= 1 where MaDH = ?";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maDH);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
    	DonHangDAO sanPhamDAO = new DonHangDAO();
        List<DonHang> list = sanPhamDAO.listallorder();
        for (DonHang o : list) {
            System.out.println(o);
        }
    }
}
