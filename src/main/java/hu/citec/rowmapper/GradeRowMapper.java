package hu.citec.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import hu.citec.entity.SubjectGrade;

public class GradeRowMapper implements RowMapper<SubjectGrade> {
	


	@Override
	public SubjectGrade mapRow(ResultSet rs, int rowNum) throws SQLException {
		SubjectGrade SubjectGrade = new SubjectGrade();
		SubjectGrade.setGrade(rs.getInt("grade"));
		SubjectGrade.setGradeDate(rs.getDate("grade_date"));
		SubjectGrade.setDescription(rs.getString("descrioption"));

		
		return SubjectGrade ;
	}

}
