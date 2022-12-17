package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.AnhSanPham;

public class AnhSanPhamDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void addProductImageByVendor(AnhSanPham anh) {
		String query = "Insert into AnhSanPham(MaSP,Anh) values(?,?)";

		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);

			ps.setInt(1, anh.getMaSP());
			ps.setString(2, anh.getAnh());

			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<AnhSanPham> listProductImageByIdProduct(int MaSp) {
		String query = "Select * from AnhSanPham where MaSP = ?";
		List<AnhSanPham> list = new ArrayList<>();

		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, MaSp);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new AnhSanPham(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;

	}

	public List<AnhSanPham> listProductImageByIdShop(int MaShop) {
		String query = "Select * from AnhSanPham where MaShop = ?";
		List<AnhSanPham> list = new ArrayList<>();

		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, MaShop);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new AnhSanPham(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}
}
