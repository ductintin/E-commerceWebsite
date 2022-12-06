package Model;

public class KhachHang {
	private int MaKH;
	private String TenKH;
	private String TenTK;
	private String Email;
	private String Phone;
	private String DiaChi;
	private String MK;
	private String NNMK;
	private int IsVeify;
	private int Role;
	
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
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(int maKH, String tenKH, String tenTK, String email, String phone, String diaChi, String mK,
			String nNMK, int isVeify, int role) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		TenTK = tenTK;
		Email = email;
		Phone = phone;
		DiaChi = diaChi;
		MK = mK;
		NNMK = nNMK;
		IsVeify = isVeify;
		Role = role;
	}
	public void setTenTK(String tenTK) {
		TenTK = tenTK;
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
	public String getMK() {
		return MK;
	}
	public void setMK(String mK) {
		MK = mK;
	}
	public String getNNMK() {
		return NNMK;
	}
	public void setNNMK(String nNMK) {
		NNMK = nNMK;
	}
	public int getIsVeify() {
		return IsVeify;
	}
	public void setIsVeify(int isVeify) {
		IsVeify = isVeify;
	}
	public int getRole() {
		return Role;
	}
	public void setRole(int role) {
		Role = role;
	}
	@Override
	public String toString() {
		return "KhachHang [MaKH=" + MaKH + ", TenKH=" + TenKH + ", TenTK=" + TenTK + ", Email=" + Email + ", Phone="
				+ Phone + ", DiaChi=" + DiaChi + ", MK=" + MK + ", NNMK=" + NNMK + ", IsVeify=" + IsVeify + ", Role="
				+ Role + "]";
	}
	
}
