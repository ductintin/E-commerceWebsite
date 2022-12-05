package Model;

public class Role {
	int MaRole;
	String RoleName;
	public Role(int maRole, String roleName) {
		super();
		MaRole = maRole;
		RoleName = roleName;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Role [MaRole=" + MaRole + ", RoleName=" + RoleName + "]";
	}
	public int getMaRole() {
		return MaRole;
	}
	public void setMaRole(int maRole) {
		MaRole = maRole;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	
	
}
