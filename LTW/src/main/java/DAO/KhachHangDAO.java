package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.KhachHang;

public class KhachHangDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public KhachHang login(String username, String password) {
		String query = "select * from KhachHang\r\n" + "where TenTK=? and MK = ? ";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();

			while (rs.next()) {
				return new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public List<KhachHang> listuser() {
		String query = "select * from KhachHang where (Role=4 or Role=3) and isDelete = 0";
		List<KhachHang> list = new ArrayList<>();

		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;

	}

	public List<KhachHang> getuserbymaKH(String maKH) {
		String query = "select * from KhachHang where MaKH = ? and isDelete=0";
		List<KhachHang> list = new ArrayList<>();
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maKH);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public List<KhachHang> getuserbymaShop(String maShop) {
		String query = "select KhachHang.MaKH, TenKH, TenTK, MK,Email,Phone,DiaChi,Role, KhachHang.isDelete\r\n"
				+ "from (((ChiTietDonHang inner join SanPham \r\n" + "on ChiTietDonHang.MaSP=SanPham.MaSP)\r\n"
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
				list.add(new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public void deleteuser(String maKH) {
		String query = "UPDATE KhachHang set isDelete= 1 where MaKH = ?";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, maKH);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		KhachHangDAO sanPhamDAO = new KhachHangDAO();
		List<KhachHang> list = sanPhamDAO.listuser();
		for (KhachHang o : list) {
			System.out.println(o);
		}
	}

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
