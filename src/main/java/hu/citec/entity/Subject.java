package hu.citec.entity;

public class Subject {

	private Integer subject_id;

	private String subject_name;

	public Subject() {

	}

	public Subject(Integer subject_id, String subject_name) {
		this.subject_id = subject_id;
		this.subject_name = subject_name;
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