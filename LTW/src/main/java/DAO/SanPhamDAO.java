package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.SanPham;

public class SanPhamDAO {
	
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void createProductByVendor(SanPham sp) {
    	
    	String query = "Insert into SanPham (MaDM,TenSP,MoTa,GiaBanThuong,GiaKhuyenMai,SoLuong,MoTaNgan,isDeleted,SoLuongDaBan,MaShop)"
    			+ "values(?,?,?,?,?,?,?,?,?,?)";
    	
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		
    		ps.setInt(1, sp.getMaDM());
    		ps.setString(2, sp.getTenSP());
    		ps.setString(3, sp.getMoTa());
    		ps.setInt(4, sp.getGiaBanThuong());
    		ps.setInt(5, sp.getGiaKhuyenMai());
    		ps.setInt(6, sp.getSoLuong());
    		ps.setString(7, sp.getMoTaNgan());
    		ps.setInt(8, 0);
    		ps.setInt(9,0);
    		ps.setInt(10, sp.getMaShop());
    		
    		ps.executeUpdate();
    		
    		
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    public SanPham getProductById(int maSP) {
    	String query = "Select * from SanPham where MaSP = ?";
    	
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		
    		ps.setInt(1, maSP);
    		
    		rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			return new SanPham(rs.getInt(1),
               		 rs.getInt(2),
                     rs.getString(3),
                     rs.getString(4),
                     rs.getInt(5),
                     rs.getInt(6),
                     rs.getInt(7),
                     rs.getString(8),
                     rs.getInt(9),
                     rs.getInt(10),
                     rs.getInt(11));
    		}
    		
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	return null;
    }
    
    
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
    
    public List<SanPham> listproducebymaDMandMaShop(String maDM, int MaShop)
    {
    	String query = "select * from SanPham where maDM=? and MaShop =? and isDeleted = 0";
        List<SanPham> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maDM);
            ps.setInt(2, MaShop);
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
    
    public List<SanPham> listProductByIdShop(int maShop){
    	String query = "select * from SanPham where isDeleted=0 and MaShop=?";
        List<SanPham> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, maShop);
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
    
    
    public int getLastIndexOfProduct() {
    	String query = "SELECT TOP 1 MaSP FROM SanPham ORDER BY MaSP DESC";
    	
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		
    		rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			return rs.getInt(1);
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	return 0;
    }
    
    public void editProductByVendor(SanPham sp) {
    	String query = "Update SanPham set TenSP = ?, MoTa = ?, GiaBanThuong = ?, GiaKhuyenMai = ?,"
    			+"SoLuong = ?, MoTaNgan = ? "
    			+"where MaSP = ?";
    	
    	try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, sp.getTenSP());
			ps.setString(2, sp.getMoTa());
			ps.setInt(3, sp.getGiaBanThuong());
			ps.setInt(4, sp.getGiaKhuyenMai());
			ps.setInt(5, sp.getSoLuong());
			ps.setString(6, sp.getMoTaNgan());
			ps.setInt(7, sp.getMaSP());
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
    	
    	
    }
    public String countuserbymounth()
    {
    	String query = "select  sum(SoLuong) from ChiTietDonHang \r\n"
    			+ "inner join DonHang on DonHang.MaDH=ChiTietDonHang.MaDH\r\n"
    			+ "where MONTH(ThoiGian)=MONTH(GETDATE()) and isDeleted=0";
    	String countproduce = null;
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);         
            rs = ps.executeQuery();
            while (rs.next()) {
            	countproduce=rs.getString(1);
            			
            }
            return countproduce;
        } catch (Exception e) {
            // TODO: handle exception
        }
		return countproduce;
    }
    public static void main(String[] args) {
    	SanPhamDAO sanPhamDAO = new SanPhamDAO();
        List<SanPham> list = sanPhamDAO.listproducebymaDH("1");
        for (SanPham o : list) {
            System.out.println(o);
        }
    }
    
    //22/12
    
    public void restoreProduct(String maSP) {
    	String query = "Update SanPham set isDeleted = 0 where MaSP = ?";
    	
    	try {
    		conn = new ConnectJDBC().getConnection();
    		
    		ps = conn.prepareStatement(query);
    		
    		ps.setString(1, maSP);
    		
    		ps.executeUpdate();
    		
    	}catch(Exception e) {
    		e.printStackTrace();
			System.out.println(e);
    	}
    }
    
    public List<SanPham> listdeletedproductbymaDMandMaShop(String maDM, int MaShop)
    {
    	String query = "select * from SanPham where maDM=? and MaShop =? and isDeleted = 1";
        List<SanPham> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maDM);
            ps.setInt(2, MaShop);
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
    
    //SP BAN CHAY NHAT
    
    public List<Integer> TopSaleProduct(int maShop){
    	List<Integer> list = new ArrayList<>();
    	
    	String query = "SELECT TOP 1 * FROM (select SanPham.MaSP,sum(ChiTietDonHang.SoLuong)as SLDB  from ChiTietDonHang inner join SanPham on ChiTietDonHang.MaSP = SanPham.MaSP and SanPham.MaShop = ? and ChiTietDonHang.MaTrangThai = 4 group by SanPham.MaSP) AS C ORDER BY C.SLDB desc;\r\n"
    			+ "";
    	
    	try {
			conn = new ConnectJDBC().getConnection();
			
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, maShop);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt(1));
				list.add(rs.getInt(2));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return list;
    }
    
}
