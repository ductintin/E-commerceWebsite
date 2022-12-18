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
    public List<DonHang> listallorderbymaDH(String maDH)
    {
    	String query = "select * from DonHang where isDeleted=0 and MaDH=?";
        List<DonHang> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,maDH);
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
    public List<DonHang> listorderbymakh(String maKH)
    {
    	String query = "select  * from DonHang where isDeleted=0 and MaKH=? ";
        List<DonHang> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maKH);
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
    public String countorderbymaKH(String maKH)
    {
    	String query = "select count(MaDH) from DonHang where isDeleted=0 and MaKH=?";
    	String countorder = null;
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query); 
            ps.setString(1, maKH);
            rs = ps.executeQuery();
            while (rs.next()) {
            	countorder=rs.getString(1);
            			
            }
            return countorder;
        } catch (Exception e) {
            // TODO: handle exception
        }
		return countorder;
    }
    
    public String totalspendfororderbymaKH(String maKH)
    {
    	String query = "select sum(TongTien) from DonHang where isDeleted=0 and MaKH=?";
    	String totalspend = null;
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query); 
            ps.setString(1, maKH);
            rs = ps.executeQuery();
            while (rs.next()) {
            	totalspend=rs.getString(1);
            			
            }
            return totalspend;
        } catch (Exception e) {
            // TODO: handle exception
        }
		return totalspend;
    }
    public String totalproduceoforderbymaKH(String maKH)
    {
    	String query = "select  sum(ChiTietDonHang.SoLuong)\r\n"
    			+ "	from DonHang inner join ChiTietDonHang on DonHang.MaDH=ChiTietDonHang.MaDH \r\n"
    			+ "	where isDeleted=0 and MaKH=? ";
    	String totalproduce = null;
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query); 
            ps.setString(1, maKH);
            rs = ps.executeQuery();
            while (rs.next()) {
            	totalproduce=rs.getString(1);
            			
            }
            return totalproduce;
        } catch (Exception e) {
            // TODO: handle exception
        }
		return totalproduce;
    }
    public String countorderbymounth()
    {
    	String query = "select COUNT(MaDH) from DonHang where isDeleted=0 and MONTH(ThoiGian)=MONTH(GETDATE())";
    	String countorder = null;
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);         
            rs = ps.executeQuery();
            while (rs.next()) {
            	countorder=rs.getString(1);
            			
            }
            return countorder;
        } catch (Exception e) {
            // TODO: handle exception
        }
		return countorder;
    }
    public String countOrderByMonth(int month) {
        String querry = "select  count(MaDH) from DonHang where MONTH(ThoiGian)=? ";
        String countorder = null;
        
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            while (rs.next()) {
            	countorder=rs.getString(1);
            			
            }
            return countorder;

        } catch (Exception e) {
        }
        return countorder;
    }
    public static void main(String[] args) {
    	DonHangDAO sanPhamDAO = new DonHangDAO();
        List<DonHang> list = sanPhamDAO.listorderbymakh("3");
        for (DonHang o : list) {
            System.out.println(o);
        }
    }
}
