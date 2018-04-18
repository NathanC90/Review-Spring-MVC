package ch04._00.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper<Member> {
	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member emp = new Member();
		emp.setPk(rs.getInt("pk"));
		emp.setUserId(rs.getString("userId"));
		emp.setPassword(rs.getString("password"));
		emp.setName(rs.getString("name"));
		emp.setEmail(rs.getString("email"));
		emp.setBirthday(rs.getDate("birthday"));
		emp.setRegDate(rs.getTimestamp("registerDate"));
		emp.setExperience(rs.getInt("experience"));
		return emp;
	}
}
