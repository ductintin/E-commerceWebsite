package Model;

public class DanhMuc {
	int MaDM;
    String TenDM;
    int isDeleted;
	public DanhMuc(int maDM, String tenDM, int isDeleted) {
		super();
		MaDM = maDM;
		TenDM = tenDM;
		this.isDeleted = isDeleted;
	}
	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DanhMuc [MaDM=" + MaDM + ", TenDM=" + TenDM + ", isDeleted=" + isDeleted + "]";
	}
	public int getMaDM() {
		return MaDM;
	}
	public void setMaDM(int maDM) {
		MaDM = maDM;
	}
	public String getTenDM() {
		return TenDM;
	}
	public void setTenDM(String tenDM) {
		TenDM = tenDM;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
    
}
