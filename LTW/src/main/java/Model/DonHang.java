package Model;

import java.util.Date;

public class DonHang {
	int MaDH;
    int MaKH;
    int TongTien;
    Date ThoiGian;
    int isDelete;
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
	
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonHang(int maDH, int maKH, int tongTien, Date thoiGian, int isDelete) {
		super();
		MaDH = maDH;
		MaKH = maKH;
		TongTien = tongTien;
		ThoiGian = thoiGian;		
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "DonHang [MaDH=" + MaDH + ", MaKH=" + MaKH + ", TongTien=" + TongTien + ", ThoiGian=" + ThoiGian
				+ ", isDelete=" + isDelete + "]";
	}
	
}