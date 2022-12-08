package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.DanhMuc;

public class DanhMucDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<DanhMuc> getallcategory() {
    	List<DanhMuc> list=new ArrayList<>();
        String query = "select DanhMuc.MaDM, TenDM, sum(SoLuong)  from DanhMuc  left join SanPham on DanhMuc.MaDM= SanPham.MaDM\r\n"
        		+ "where DanhMuc.isDeleted=0\r\n"
        		+ "group by DanhMuc.MaDM, TenDM";
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
    public void deletecategory(String maDM)
    {
    	String query = "UPDATE DanhMuc set isDeleted= 1 where MaDM = ?";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maDM);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void createcategory(String tenDM)
    {
    	String query = "insert into DanhMuc(TenDM,isDeleted) Values(?,0);";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tenDM);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        DanhMucDAO sanPhamDAO = new DanhMucDAO();
        List<DanhMuc> list = sanPhamDAO.getallcategory();
        for (DanhMuc o : list) {
            System.out.println(o);
        }
    }
}
