package hu.citec.entity;

public class UserRole {
	private Integer userid;

	private String username;

	private String password;

	private String fullname;

	private String email;

	private boolean activated;
	
	private Integer roleid;

	private String role_type;

	public UserRole(Integer userid, String username, String password, String fullname, String email, boolean activated,
			Integer roleid, String role_type) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.activated = activated;
		this.roleid = roleid;
		this.role_type = role_type;
	}

	public UserRole() {
		
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRole_type() {
		return role_type;
	}

	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}

	@Override
	public String toString() {
		return "UserRole [userid=" + userid + ", username=" + username + ", password=" + password + ", fullname="
				+ fullname + ", email=" + email + ", activated=" + activated + ", roleid=" + roleid + ", role_type="
				+ role_type + "]";
	}
	
	
	
	

}
