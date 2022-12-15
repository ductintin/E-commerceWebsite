package Model;

public class SanPham {
	int MaSP;
	int MaDM;
	String TenSP;
	String MoTa;
	int GiaBanThuong;
	int GiaKhuyenMai;
	int SoLuong;
	String MoTaNgan;
	int isDeteted;
	int SoLuongDaBan;
	int MaShop;
	
	public SanPham(int maSP, int maDM, String tenSP, String moTa, int giaBanThuong, int giaKhuyenMai, int soLuong,
			 String moTaNgan, int isDeteted, int soLuongDaBan, int maShop) {
		super();
		MaSP = maSP;
		MaDM = maDM;
		TenSP = tenSP;
		MoTa = moTa;
		GiaBanThuong = giaBanThuong;
		GiaKhuyenMai = giaKhuyenMai;
		SoLuong = soLuong;
		MoTaNgan = moTaNgan;
		this.isDeteted = isDeteted;
		SoLuongDaBan = soLuongDaBan;
		MaShop = maShop;
	}
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaSP() {
		return MaSP;
	}
	public void setMaSP(int maSP) {
		MaSP = maSP;
	}
	public int getMaDM() {
		return MaDM;
	}
	public void setMaDM(int maDM) {
		MaDM = maDM;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public int getGiaBanThuong() {
		return GiaBanThuong;
	}
	public void setGiaBanThuong(int giaBanThuong) {
		GiaBanThuong = giaBanThuong;
	}
	public int getGiaKhuyenMai() {
		return GiaKhuyenMai;
	}
	public void setGiaKhuyenMai(int giaKhuyenMai) {
		GiaKhuyenMai = giaKhuyenMai;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	
	public String getMoTaNgan() {
		return MoTaNgan;
	}
	public void setMoTaNgan(String moTaNgan) {
		MoTaNgan = moTaNgan;
	}
	public int getIsDeteted() {
		return isDeteted;
	}
	public void setIsDeteted(int isDeteted) {
		this.isDeteted = isDeteted;
	}
	public int getSoLuongDaBan() {
		return SoLuongDaBan;
	}
	public void setSoLuongDaBan(int soLuongDaBan) {
		SoLuongDaBan = soLuongDaBan;
	}
	public int getMaShop() {
		return MaShop;
	}
	public void setMaShop(int maShop) {
		MaShop = maShop;
	}
	@Override
	public String toString() {
		return "SanPham [MaSP=" + MaSP + ", MaDM=" + MaDM + ", TenSP=" + TenSP + ", MoTa=" + MoTa + ", GiaBanThuong="
				+ GiaBanThuong + ", GiaKhuyenMai=" + GiaKhuyenMai + ", SoLuong=" + SoLuong 
				+ ", MoTaNgan=" + MoTaNgan + ", isDeteted=" + isDeteted + ", SoLuongDaBan=" + SoLuongDaBan + ", MaShop="
				+ MaShop + "]";
	}
	
	
}
