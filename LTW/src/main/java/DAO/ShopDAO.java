package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.Shop;

public class ShopDAO {
	
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    KhachHangDAO KHDao = new KhachHangDAO();
    
    public void createShop(Shop shop, int maSeller) {
    	String query = "Insert into Shop (MaSeller,TenShop,PhoneShop,DiaChiShop,EmailShop,isDelete) values (?,?,?,?,?,?)";
    	
    	
    	try {
    		conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setInt(1, maSeller);
            ps.setString(2, shop.getTenShop());
            ps.setString(3, shop.getPhoneShop());
            ps.setString(4, shop.getDiaChiShop());
            ps.setString(5, shop.getEmailShop());
            ps.setInt(6, shop.getIsDeleted());
            
            ps.executeUpdate();
            
            
            
    	}catch(Exception e) {
    		System.out.print(e);
    	}
    	
    }
    
    public Shop getShopByMaSeller(int MaSeller) {
    	String query = "Select * from Shop where MaSeller = ?";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		
    		ps.setInt(1,MaSeller);
    		rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			   			
    			Shop shop = new Shop();
    			shop.setMaShop(rs.getInt(1));
    			shop.setMaSeller(rs.getInt(2));
    			shop.setTenShop(rs.getString(3));
    			shop.setPhoneShop(rs.getString(4));
    			shop.setDiaChiShop(rs.getString(5));
    			shop.setEmailShop(rs.getString(6));
    			shop.setIsDeleted(rs.getInt(7));
    			
    			return shop;
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	return null;   	
    }
    
    //moi
    
    public Shop getShopByMaShop(int MaShop) {
    	String query = "Select * from Shop where MaShop = ?";
    	try {
    		conn = new ConnectJDBC().getConnection();
    		ps = conn.prepareStatement(query);
    		
    		ps.setInt(1,MaShop);
    		rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			   			
    			Shop shop = new Shop();
    			shop.setMaShop(rs.getInt(1));
    			shop.setMaSeller(rs.getInt(2));
    			shop.setTenShop(rs.getString(3));
    			shop.setPhoneShop(rs.getString(4));
    			shop.setDiaChiShop(rs.getString(5));
    			shop.setEmailShop(rs.getString(6));
    			shop.setIsDeleted(rs.getInt(7));
    			
    			return shop;
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	return null;   	
    }
    
    public void EditProfile(Shop shop) {
    	String query = "UPDATE Shop set TenShop = ?, EmailShop = ?, PhoneShop = ?, DiaChiShop = ? WHERE MaShop = ?";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, shop.getTenShop());
			ps.setString(2, shop.getEmailShop());
			ps.setString(3, shop.getPhoneShop());
			ps.setString(4, shop.getDiaChiShop());
			ps.setInt(5, shop.getMaShop());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
    //end
    
    public String getShopNameByIdShop(int MaShop) {
    	String query = "Select TenShop from Shop where MaShop = ?";
    	
    	try {
    		conn = new ConnectJDBC().getConnection();
    		
    		ps = conn.prepareStatement(query);
    		ps.setInt(1, MaShop);
    		rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			return rs.getString(1);
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	return null;
    }
    
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
    
    //23/12
    
    public List<Integer> selectMaKhachHangofShop(int maShop){
    	String query = "SELECT DISTINCT DonHang.MaKH FROM (DonHang inner join ChiTietDonHang on DonHang.MaDH = ChiTietDonHang.MaDH and DonHang.isDeleted = 0 "
    +" inner join SanPham on ChiTietDonHang.MaSP = SanPham.MaSP and ChiTietDonHang.MaTrangThai = 4" 
    			+" inner join Shop on SanPham.MaShop = Shop.MaShop) where Shop.MaShop = ? ";
    	
    	List<Integer> listMaKH = new ArrayList<Integer>();
    	
    	try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, maShop);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				listMaKH.add(rs.getInt(1));
			}
			
			return listMaKH;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    	
    	return listMaKH;
    }
    
    
}
