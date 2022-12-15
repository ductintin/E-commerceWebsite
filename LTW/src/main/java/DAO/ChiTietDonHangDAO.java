package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.ChiTietDonHang;
import Model.DonHang;

public class ChiTietDonHangDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<ChiTietDonHang> getorderdetailbymaDH(String maDH)
    {
    	String query = "select * from ChiTietDonHang where MaDH=?";
        List<ChiTietDonHang> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,maDH);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new ChiTietDonHang(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    public List<ChiTietDonHang> getorderdetailbymaShop(String maShop)
    {
    	String query = "select ChiTietDonHang.MaCTDH,ChiTietDonHang.MaDH,ChiTietDonHang.MaSP,ChiTietDonHang.SoLuong, TongTien\r\n"
    			+ "from (ChiTietDonHang inner join SanPham \r\n"
    			+ "on ChiTietDonHang.MaSP=SanPham.MaSP)\r\n"
    			+ "inner join Shop on Shop.MaShop=SanPham.MaShop\r\n"
    			+ "where Shop.MaShop=? and Shop.isDelete=0";
        List<ChiTietDonHang> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,maShop);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new ChiTietDonHang(rs.getInt(1),
                		 rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
}