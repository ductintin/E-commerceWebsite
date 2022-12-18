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
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    public List<ChiTietDonHang> getorderdetailbymaShop(String maShop)
    {
    	String query = "select ChiTietDonHang.MaCTDH,ChiTietDonHang.MaDH,ChiTietDonHang.MaSP,ChiTietDonHang.SoLuong, TongTien, MaTrangThai\r\n"
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
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    public float countProduceByMonth(int month) {
        String querry = "select  sum(SoLuong) from ChiTietDonHang \r\n"
        		+ "inner join DonHang on DonHang.MaDH=ChiTietDonHang.MaDH\r\n"
        		+ "where MONTH(ThoiGian)=? and isDeleted=0 ";
        float sumproduce = 0;
        
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            while (rs.next()) {
            	sumproduce=rs.getInt(1);
            			
            }
            return sumproduce;

        } catch (Exception e) {
        }
        return sumproduce;
    }
    public static void main(String[] args) {
    	ChiTietDonHangDAO sanPhamDAO = new ChiTietDonHangDAO();
    	List<Float> sumproducebymonth = new ArrayList<Float>();
    	List<Float> sumproducebypercent = new ArrayList<Float>();
    	
    	for (int i = 0; i < 4; i++) {
			float total=0;
			for (int j = 1; j <= 4; j++)
			{
				total+=sanPhamDAO.countProduceByMonth(i*3+j);
			}
			sumproducebymonth.add(total);		
		}
		int total=0;
		for (float i : sumproducebymonth) {
			total+=i;		
		}
		for (float i : sumproducebymonth) {
			sumproducebypercent.add((float) ((i/total)*100));		
		}
//        List<ChiTietDonHang> list = sanPhamDAO.getorderdetailbymaShop("1");
        for (float o : sumproducebypercent) {
           System.out.println(o);
        }
		
    }
}
