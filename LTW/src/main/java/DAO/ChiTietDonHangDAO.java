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
}
