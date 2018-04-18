package ch02._01_setter._03.sqlserver;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper<Member> {
	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member emp = new Member();
		emp.setPk(rs.getInt("pk"));
		emp.setUserId(rs.getString("account"));
		emp.setPassword(rs.getString("password"));
		emp.setName(rs.getString("name"));
		emp.setEmail(rs.getString("email"));
		emp.setTel(rs.getString("tel"));
		emp.setExperience(rs.getInt("experience"));
		return emp;
	}
}
