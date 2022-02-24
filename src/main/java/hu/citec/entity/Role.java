package hu.citec.entity;

public class Role {

	private Integer role_id;

	private String role_type;

	public Role() {

	}

	public Role(Integer role_id, String role_type) {

		this.role_id = role_id;
		this.role_type = role_type;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_type() {
		return role_type;
	}

	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}

}