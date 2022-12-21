package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import Connection.ConnectJDBC;
import Model.KhachHang;


import org.mindrot.jbcrypt.BCrypt;
public class KhachHangDAO {
	
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    RoleDAO roleDao;
    public KhachHang login(String username, String password) {
        String query = "select * from KhachHang\r\n"
                + "where TenTK=? and MK = ? and isDelete = 0";

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new KhachHang(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }
    
    public KhachHang createVendor(KhachHang KH) {
    	
    	try {
    		conn = new ConnectJDBC().getConnection();
			/*
			 * KH.setMK(BCrypt.hashpw(KH.getMK(), BCrypt.gensalt(4))); KH.setRole(2);
			 * String[] email = KH.getEmail().split("@"); KH.setEmail(email[0] + "+" +
			 * BCrypt.hashpw("", BCrypt.gensalt(4)) + "@" + email[1]); return KH;
			 */
    		
    		String query = "Insert into KhachHang values(?,?,?,?,?,?,?,?)";
    		 ps = conn.prepareStatement(query);
    		 ps.setString(1, KH.getTenKH());
             ps.setString(2, KH.getTenTK());
             ps.setString(3, KH.getMK());
             ps.setString(4, KH.getEmail());
             ps.setString(5, KH.getPhone());
             ps.setString(6, KH.getDiaChi());
             ps.setInt(7, KH.getRole());
             ps.setInt(8, KH.getIsDelete());
             ps.executeUpdate();
             
    		
		}catch(Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    
    public List<KhachHang> listVendor()
    {
    	String query = "select * from KhachHang where Role=3";
        List<KhachHang> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new KhachHang(rs.getInt(1),
	                    rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),	                    
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return list;
    
    }
    
    //Moi
    public KhachHang findVendorById(int maKH) {
    	try {
    		conn = new ConnectJDBC().getConnection();
    		String sql = "Select * from KhachHang where Role = 2 and MaKH = ?";
    		ps = conn.prepareStatement(sql);
    		ps.setInt(1, maKH);
            rs = ps.executeQuery();
            
            while(rs.next()) {
            	return new KhachHang(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
    	}catch(Exception e) {
    		
    	}
    	
    	return null;
    }
    //end
    
    public KhachHang findVendorByAccountName(String accountName) {
    	try {
    		conn = new ConnectJDBC().getConnection();
    		String sql = "Select * from KhachHang where Role = 2 and TenTK = ?";
    		ps = conn.prepareStatement(sql);
    		ps.setString(1, accountName);
            rs = ps.executeQuery();
            
            while(rs.next()) {
            	return new KhachHang(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
            }
    	}catch(Exception e) {
    		
    	}
    	
    	return null;
    }
    
    public int getIdVendorByAccountName(String accountName) {
    	try {
    		conn = new ConnectJDBC().getConnection();
    		String sql = "Select * from KhachHang where Role = 2 and TenTK = ?";
    		ps = conn.prepareStatement(sql);
    		ps.setString(1, accountName);
            rs = ps.executeQuery();
            
            while(rs.next()) {
            	return rs.getInt(1);
            }
    	}catch(Exception e) {
    		System.out.print(e);
    	}
        
    	return -1;
    }
    
	/*
	 * public void ChangePasswordVendor(String accountName, String password) {
	 * String query = "UPDATE KhachHang set MK = ? where TenTK = ?"; try { conn =
	 * new ConnectJDBC().getConnection(); ps = conn.prepareStatement(query);
	 * ps.setString(1, password); ps.setString(2, accountName); ps.executeUpdate();
	 * } catch (Exception e) { } }
	 */
    
    public List<KhachHang> getuserbymaKH(String maKH)
    {
    	String query = "select * from KhachHang where MaKH = ? and isDelete=0";
    	List<KhachHang> list = new ArrayList<>();
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query); 
            ps.setString(1, maKH);
            rs = ps.executeQuery();
            while (rs.next()) {
                 list.add(new KhachHang(rs.getInt(1),
	                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return list;
    }
    public List<KhachHang> getuserbymaShop(String maShop)
    {
    	String query = "select KhachHang.MaKH, TenKH, TenTK, MK,Email,Phone,DiaChi,Role, KhachHang.isDelete\r\n"
    			+ "from (((ChiTietDonHang inner join SanPham \r\n"
    			+ "on ChiTietDonHang.MaSP=SanPham.MaSP)\r\n"
    			+ "inner join Shop on Shop.MaShop=SanPham.MaShop)\r\n"
    			+ "inner join DonHang on DonHang.MaDH =ChiTietDonHang.MaDH)\r\n"
    			+ "inner join KhachHang on KhachHang.MaKH= DonHang.MaKH\r\n"
    			+ "where Shop.MaShop=? and Shop.isDelete=0";
    	List<KhachHang> list = new ArrayList<>();
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query); 
            ps.setString(1, maShop);
            rs = ps.executeQuery();
            while (rs.next()) {
                 list.add(new KhachHang(rs.getInt(1),
	                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return list;
    }
    public void deleteuser(String maKH)
    {
    	String query = "UPDATE KhachHang set isDelete= 1 where MaKH = ?";
        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, maKH);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
	/*
	 * public static void main(String[] args) { KhachHangDAO sanPhamDAO = new
	 * KhachHangDAO(); List<KhachHang> list = sanPhamDAO.listuser(); for (KhachHang
	 * o : list) { System.out.println(o); } }
	 */
    
    public KhachHang findCustomerByAccountName(String accountName) {
		try {
			conn = new ConnectJDBC().getConnection();
			String sql = "Select * from KhachHang where Role = 3 and TenTK = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, accountName);
			rs = ps.executeQuery();

			while (rs.next()) {
				return new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
			}
		} catch (Exception e) {

		}

		return null;
	}

	public void createCustomer(KhachHang KH) {
		try {
			conn = new ConnectJDBC().getConnection();
			/*
			 * KH.setMK(BCrypt.hashpw(KH.getMK(), BCrypt.gensalt(4))); KH.setRole(2);
			 * String[] email = KH.getEmail().split("@"); KH.setEmail(email[0] + "+" +
			 * BCrypt.hashpw("", BCrypt.gensalt(4)) + "@" + email[1]); return KH;
			 */

			String query = "Insert into KhachHang values(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, KH.getTenKH());
			ps.setString(2, KH.getTenTK());
			ps.setString(3, KH.getMK());
			ps.setString(4, KH.getEmail());
			ps.setString(5, KH.getPhone());
			ps.setString(6, KH.getDiaChi());
			ps.setInt(7, KH.getRole());
			ps.setInt(8, KH.getIsDelete());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ChangePasswordCustomer(String accountName, String password) {
		String query = "UPDATE KhachHang set MK = ? where TenTK = ?";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, accountName);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	public String userofmounth()
    {
    	String query = "select top(1) TenKH, count(MaDH) as TongDH\r\n"
    			+ "from KhachHang \r\n"
    			+ "inner join DonHang on DonHang.MaKH=KhachHang.MaKH\r\n"
    			+ "where DonHang.isDeleted=0 and MONTH(ThoiGian)=MONTH(GETDATE())\r\n"
    			+ "group by TenKH\r\n"
    			+ "order by TongDH DESC";
    	String tenkh = null;
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);         
            rs = ps.executeQuery();
            while (rs.next()) {
            	tenkh=rs.getString(1);
            			
            }
            return tenkh;
        } catch (Exception e) {
            // TODO: handle exception
        }
		return tenkh;
    }
    public String orderofuserbymounth()
    {
    	String query = "select top(1) TenKH, count(MaDH) as TongDH\r\n"
    			+ "from KhachHang \r\n"
    			+ "inner join DonHang on DonHang.MaKH=KhachHang.MaKH\r\n"
    			+ "where DonHang.isDeleted=0 and MONTH(ThoiGian)=MONTH(GETDATE())\r\n"
    			+ "group by TenKH\r\n"
    			+ "order by TongDH DESC";
    	String tongdh = null;
    	try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);         
            rs = ps.executeQuery();
            while (rs.next()) {
            	tongdh=rs.getString(2);
            			
            }
            return tongdh;
        } catch (Exception e) {
            // TODO: handle exception
        }
		return tongdh;
    } public List<KhachHang> listuser()
    {
    	String query = "select * from KhachHang where (Role=4 or Role=3) and isDelete = 0";
        List<KhachHang> list = new ArrayList<>();

        try {
            conn = new ConnectJDBC().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                 list.add(new KhachHang(rs.getInt(1),
	                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return list;
    
    }
	public void EditProfile(KhachHang KH) {
		String query = "UPDATE KhachHang set TenKH = ?, Email = ?, Phone = ?, DiaChi = ? WHERE MaKH = ?";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, KH.getTenKH());
			ps.setString(2, KH.getEmail());
			ps.setString(3, KH.getPhone());
			ps.setString(4, KH.getDiaChi());
			ps.setInt(5, KH.getMaKH());
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
}
