package Model;

import java.util.HashSet;
import java.util.Set;

public class DanhMuc {
	int MaDM;
    String TenDM;
    int isDeleted;
    
    public Set <SanPham> products;
    
	public Set<SanPham> getProducts() {
		return products;
	}
	public void setProducts(Set<SanPham> products) {
		this.products = products;
	}
	public void addProduct(SanPham product)  {
	      if(this.products == null)  {
	          this.products= new HashSet<SanPham>();
	      }
	      this.products.add(product);
	  }
	
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
