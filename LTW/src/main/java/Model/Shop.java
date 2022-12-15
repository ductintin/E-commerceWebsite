package Model;

public class Shop {
	int MaShop;
	int MaSeller;
	String TenShop;
	String PhoneShop;
	String DiaChiShop;
	String EmailShop;
	int isDelete;
	public int getMaShop() {
		return MaShop;
	}
	public void setMaShop(int maShop) {
		MaShop = maShop;
	}
	public int getMaSeller() {
		return MaSeller;
	}
	public void setMaSeller(int maSeller) {
		MaSeller = maSeller;
	}
	public String getTenShop() {
		return TenShop;
	}
	public void setTenShop(String tenShop) {
		TenShop = tenShop;
	}
	public String getPhoneShop() {
		return PhoneShop;
	}
	public void setPhoneShop(String phoneShop) {
		PhoneShop = phoneShop;
	}
	public String getDiaChiShop() {
		return DiaChiShop;
	}
	public void setDiaChiShop(String diaChiShop) {
		DiaChiShop = diaChiShop;
	}
	public String getEmailShop() {
		return EmailShop;
	}
	public void setEmailShop(String emailShop) {
		EmailShop = emailShop;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop(int maShop, int maSeller, String tenShop, String phoneShop, String diaChiShop, String emailShop,
			int isDelete) {
		super();
		MaShop = maShop;
		MaSeller = maSeller;
		TenShop = tenShop;
		PhoneShop = phoneShop;
		DiaChiShop = diaChiShop;
		EmailShop = emailShop;
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "Shop [MaShop=" + MaShop + ", MaSeller=" + MaSeller + ", TenShop=" + TenShop + ", PhoneShop=" + PhoneShop
				+ ", DiaChiShop=" + DiaChiShop + ", EmailShop=" + EmailShop + ", isDelete=" + isDelete + "]";
	}
	
	
}