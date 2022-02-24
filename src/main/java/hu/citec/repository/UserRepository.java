package hu.citec.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;


import hu.citec.entity.Subject;
import hu.citec.entity.SubjectGrade;
import hu.citec.entity.User;
import hu.citec.entity.UserRole;
import hu.citec.entity.UserSubject;
import hu.citec.rowmapper.GradeRowMapper;
import hu.citec.rowmapper.UserRowMapper;

@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<UserSubject> findGrade(String username) {
		String query = "SELECT s.subject_name,sg.grade,sg.grade_date,u1.fullname FROM subject s Left JOIN subject_grade sg ON sg.subject_id=s.subject_id Left join users u1 ON u1.user_id= sg.teacher_id Left join users u2 ON u2.user_id= sg.user_id WHERE u2.username= ?";

		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(UserSubject.class), username);
	}

	public User findUser(String username) {
		String query = "Select user_id, username, fullname, email, activated, blocked FROM users WHERE username = ?";

		return jdbcTemplate.queryForObject(query, new UserRowMapper(), username);
	}

	public List<UserRole> findAllDiak() {
		String query = "SELECT u.fullname, u.username FROM role r LEFT JOIN user_roles ur ON ur.role_id=r.role_id LEFT JOIN users u ON u.user_id = ur.user_id WHERE r.role_type ='DIAK' AND u.activated = '1'";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(UserRole.class));
	}

	public List<UserRole> adminShow() {
		String query = "SELECT u.fullname,u.username,u.email,u.activated,r.role_type from users u LEFT JOIN user_roles ur ON ur.user_id=u.user_id LEFT JOIN role r on r.role_id = ur.role_id";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(UserRole.class));

	}

	public List<Subject> findSubject() {
		String query = "SELECT subject_name from subject";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Subject.class));
	}

	public List<SubjectGrade> grade(String subjectName, String username) {
		String query = "SELECT sg.grade,sg.grade_date,sg.descrioption FROM subject_grade sg LEFT JOIN subject s on sg.subject_id = s.subject_id LEFT JOIN users u on u.user_id = sg.user_id WHERE (s.subject_name=? AND u.username=?)";

		return jdbcTemplate.query(query, new GradeRowMapper(), subjectName, username);
	}

	public void registrateUser(User user) {

		String query = "INSERT INTO users( username, user_password, fullname, email,activated) VALUES (?,?,?,?,'1')";
		jdbcTemplate.update(query, user.getUsername(), user.getPassword(), user.getFullname(), user.getEmail());
	}

	public void deleteUser(String username) {
		String query = "DELETE FROM users WHERE user_id=?";
		jdbcTemplate.update(query, username);
	}

	public void blockUser(String username) {
		String query = "UPDATE users SET activated='0',blocked='1' WHERE user_id = ?";
		jdbcTemplate.update(query, username);
	}

}
