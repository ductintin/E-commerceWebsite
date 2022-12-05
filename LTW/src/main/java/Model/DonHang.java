package Model;

import java.util.Date;

public class DonHang {
	int MaDH;
    int MaKH;
    int TongTien;
    Date ThoiGian;
    int MaTrangThai;
	public DonHang(int maDH, int maKH, int tongTien, Date thoiGian, int maTrangThai) {
		super();
		MaDH = maDH;
		MaKH = maKH;
		TongTien = tongTien;
		ThoiGian = thoiGian;
		MaTrangThai = maTrangThai;
	}
	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaDH() {
		return MaDH;
	}
	public void setMaDH(int maDH) {
		MaDH = maDH;
	}
	public int getMaKH() {
		return MaKH;
	}
	public void setMaKH(int maKH) {
		MaKH = maKH;
	}
	public int getTongTien() {
		return TongTien;
	}
	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}
	public Date getThoiGian() {
		return ThoiGian;
	}
	public void setThoiGian(Date thoiGian) {
		ThoiGian = thoiGian;
	}
	public int getMaTrangThai() {
		return MaTrangThai;
	}
	public void setMaTrangThai(int maTrangThai) {
		MaTrangThai = maTrangThai;
	}
	@Override
	public String toString() {
		return "DonHang [MaDH=" + MaDH + ", MaKH=" + MaKH + ", TongTien=" + TongTien + ", ThoiGian=" + ThoiGian
				+ ", MaTrangThai=" + MaTrangThai + "]";
	}
    
}
