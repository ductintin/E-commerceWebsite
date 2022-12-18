package Model;

public class ChiTietDonHang {
	int MaCTDH;
	int MaDH;
    int MaSP;
    int SoLuong;
    int TongTien;
    int MaTrangThai;
	public int getMaCTDH() {
		return MaCTDH;
	}
	public void setMaCTDH(int maCTDH) {
		MaCTDH = maCTDH;
	}
	public int getMaDH() {
		return MaDH;
	}
	public void setMaDH(int maDH) {
		MaDH = maDH;
	}
	public int getMaSP() {
		return MaSP;
	}
	public void setMaSP(int maSP) {
		MaSP = maSP;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getTongTien() {
		return TongTien;
	}
	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}
	public int getMaTrangThai() {
		return MaTrangThai;
	}
	public void setMaTrangThai(int maTrangThai) {
		MaTrangThai = maTrangThai;
	}
	public ChiTietDonHang(int maCTDH, int maDH, int maSP, int soLuong, int tongTien, int maTrangThai) {
		super();
		MaCTDH = maCTDH;
		MaDH = maDH;
		MaSP = maSP;
		SoLuong = soLuong;
		TongTien = tongTien;
		MaTrangThai = maTrangThai;
	}
	public ChiTietDonHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChiTietDonHang [MaCTDH=" + MaCTDH + ", MaDH=" + MaDH + ", MaSP=" + MaSP + ", SoLuong=" + SoLuong
				+ ", TongTien=" + TongTien + ", MaTrangThai=" + MaTrangThai + "]";
	}
	
    
}
