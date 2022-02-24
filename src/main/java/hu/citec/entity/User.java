package hu.citec.entity;

public class User {

	private Integer userid;

	private String username;

	private String password;

	private String fullname;

	private String email;

	private boolean activated;




	public User() {

	}


	public User(Integer userid, String username, String password, String fullname, String email, boolean activated) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.activated = activated;
		
	}


	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer user_id) {
		this.userid = user_id;
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



}