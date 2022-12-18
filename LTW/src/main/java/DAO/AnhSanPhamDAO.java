package DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectJDBC;
import Model.AnhSanPham;
import Model.SanPham;

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

	public void editAnhSanPhamByVendor(AnhSanPham anh, int maSP) {
		String query = "Update AnhSanPham set Anh = ? where MaSP = ? and MaAnhSP = ?";

		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, anh.getAnh());
			ps.setInt(2, maSP);
			ps.setInt(3, anh.getMaAnhSP());

			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("loi day ha"+e);
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

	/*
	 * public void edit(SanPham newSP) { SanPhamDAO spDAO = new SanPhamDAO();
	 * SanPham oldSP = spDAO.getProductById(newSP.getMaSP()); if
	 * (newSP.getProductImages() != null) { // XOA ANH CU DI for(AnhSanPham i :
	 * oldSP.getProductImages()) { String fileName = i.getAnh(); final String dir =
	 * "D:\\upload"; File file = new File(dir + "/product" + fileName); if
	 * (file.exists()) { file.delete(); } }
	 * 
	 * oldSP.setProductImages(newSP.getProductImages()); }
	 * 
	 * spDAO.editProductByVendor(oldSP);
	 * 
	 * }
	 */

	public void edit(List<AnhSanPham> anh, int maSP) {
		AnhSanPhamDAO anhDao = new AnhSanPhamDAO();
		List<AnhSanPham> oldAnh = anhDao.listProductImageByIdProduct(maSP);

		try {
			for (int i = 0; i < oldAnh.size(); i++) {
				if (anh.get(i).getAnh() != null) {
					// XOA ANH CU DI
					String fileName = oldAnh.get(i).getAnh();
					final String dir = "D:\\upload";
					File file = new File(dir + "/product" + fileName);
					if (file.exists()) {
						file.delete();
					}
					oldAnh.get(i).setAnh(anh.get(i).getAnh());

					anhDao.editAnhSanPhamByVendor(oldAnh.get(i), maSP);
				}

			}
		}catch(Exception e) {
			System.out.println("LOi ne"+e);
		}
	}
}
