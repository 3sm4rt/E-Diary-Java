package hu.citec.entity;

import java.sql.Date;

public class SubjectGrade {

	private Integer id;
	
	

	private Date gradeDate;

	private String description;
	
	private Integer teacherId;

	private Integer grade;
	
	private String subject_name;

	public SubjectGrade() {

	}

	public SubjectGrade(Integer id, Date gradeDate, String description, Integer teacherId, Integer grade,
			String subject_name) {
		
		this.id = id;
		this.gradeDate = gradeDate;
		this.description = description;
		this.teacherId = teacherId;
		this.grade = grade;
		this.subject_name = subject_name;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getGradeDate() {
		return gradeDate;
	}

	public void setGradeDate(Date gradeDate) {
		this.gradeDate = gradeDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	
	

}