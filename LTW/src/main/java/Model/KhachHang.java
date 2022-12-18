package Model;

public class KhachHang {
	private int MaKH;
	private String TenKH;
	private String TenTK;
	private String MK;
	private String Email;
	private String Phone;
	private String DiaChi;
	private int Role;
	private int isDelete;

	public int getMaKH() {
		return MaKH;
	}
	public void setMaKH(int maKH) {
		MaKH = maKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getTenTK() {
		return TenTK;
	}
	public void setTenTK(String tenTK) {
		TenTK = tenTK;
	}
	public String getMK() {
		return MK;
	}
	public void setMK(String mK) {
		MK = mK;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public int getRole() {
		return Role;
	}
	public void setRole(int role) {
		Role = role;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(int maKH, String tenKH, String tenTK, String mK, String email, String phone, String diaChi,
			int role, int isDelete) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		TenTK = tenTK;
		MK = mK;
		Email = email;
		Phone = phone;
		DiaChi = diaChi;
		Role = role;
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "KhachHang [MaKH=" + MaKH + ", TenKH=" + TenKH + ", TenTK=" + TenTK + ", MK=" + MK + ", Email=" + Email
				+ ", Phone=" + Phone + ", DiaChi=" + DiaChi + ", Role=" + Role + ", isDelete=" + isDelete + "]";
	}
	

}