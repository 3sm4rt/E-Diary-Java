package hu.citec.entity;

import java.sql.Date;

public class UserSubject {
	private Integer userid;
	private Integer roleid;

	private String username;

	private String password;

	private String fullname;

	private String email;

	private boolean activated;

	private Integer grade;
	
	private Date grade_date;
	
	private Integer subject_id;

	private String subject_name;

	public UserSubject() {
		
	}

	public UserSubject(Integer userid, Integer roleid, String username, String password, String fullname, String email,
			boolean activated, Integer grade, Date grade_date, Integer subject_id, String subject_name) {
		
		this.userid = userid;
		this.roleid = roleid;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.activated = activated;
		this.grade = grade;
		this.grade_date = grade_date;
		this.subject_id = subject_id;
		this.subject_name = subject_name;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Date getGrade_date() {
		return grade_date;
	}

	public void setGrade_date(Date grade_date) {
		this.grade_date = grade_date;
	}

	public Integer getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
	
	

}