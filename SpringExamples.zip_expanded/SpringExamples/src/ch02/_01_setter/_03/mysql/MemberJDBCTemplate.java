package ch02._01_setter._03.mysql;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
public class MemberJDBCTemplate implements MemberDAO {

	private JdbcTemplate jdbcTemplateObject;
	public MemberJDBCTemplate() {
	}
	
//	public MemberJDBCDataSource(JdbcTemplate template) {
//		this.jdbcTemplateObject = template;
//	}

	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public Integer save(Member member) {
		Integer count = 0 ;
		String SQL = "insert into MemberExample "
				+ " (pk, account, password, name, email, tel, experience) "
				+ " values (null, ?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(SQL, member.getUserId(),
				member.getPassword(), member.getName(), member.getEmail(),
				member.getTel(), member.getExperience());
		count++;
		System.out.println("Created Record Name = " + member.getName()
				+ " account = " + member.getUserId());
		return count;
	}

	public Member get(Integer pk) {
		String SQL = "select * from MemberExample where pk = ?";
		Member student = jdbcTemplateObject.queryForObject(SQL,
				new Object[] { pk }, new MemberMapper());
		return student;
	}

	public Integer delete(Integer pk) {
		Integer count = 0;
		String SQL = "delete from MemberExample where pk = ?";
		jdbcTemplateObject.update(SQL, pk);
		count++;
		System.out.println("刪除記錄, 主鍵  = " + pk);
		return count;
	}

	public Integer update(Member member) {
		Integer count = 0;
		String SQL = "update MemberExample set  password = ?, "
				+ "name = ?, email = ?, tel =?, experience = ? where account = ?";
		jdbcTemplateObject.update(SQL, member.getPassword(), 
				member.getName(), member.getEmail(),	
				member.getTel(), member.getExperience(), 
		        member.getUserId());
		count++;
		System.out.println("刪除記錄, account  = " + member.getUserId());
		return count;
	}

	@Override
	public List<Member> getAll() {
		String SQL = "select * from MemberExample";
		List<Member> members = jdbcTemplateObject
				.query(SQL, new MemberMapper());
		return members;
	}
	
	public void createTable(String sql){
		jdbcTemplateObject.update(sql);
		System.out.println("執行SQL命令成功");
	}
}
