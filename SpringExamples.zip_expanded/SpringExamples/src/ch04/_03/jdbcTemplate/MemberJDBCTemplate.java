package ch04._03.jdbcTemplate;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ch04._00.model.Member;
import ch04._00.model.MemberDAO;
import ch04._00.model.MemberMapper;

public class MemberJDBCTemplate implements MemberDAO {

	private JdbcTemplate jdbcTemplateObject;

	public MemberJDBCTemplate(JdbcTemplate template) {
		this.jdbcTemplateObject = template;
	}

	public Integer save(Member member) {
		int count = 0 ;
		String SQL = "insert into SpringMember "
				+ " (pk, userId, password, name, email, birthday, registerDate, experience) "
				+ " values ( ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(SQL, member.getUserId(),
				member.getPassword(), member.getName(), 
				member.getEmail(), member.getBirthday(), 
				member.getRegDate(), member.getExperience()
			);
		count++;
		System.out.println("新建會員資料成功");
		return count;
	}

	public Member get(Integer pk) {
		String SQL = "select * from SpringMember where pk = ?";
//      如果確定有該筆記錄: 		
//		Member student = jdbcTemplateObject.queryForObject(SQL,
//				new Object[] { pk }, new MemberMapper());
//		return student;
//      如果不確定是否有該筆記錄: 		
		Member student = null;
		List<Member> list = jdbcTemplateObject.query(SQL,
				new Object[] { pk }, new int[]{java.sql.Types.INTEGER}, 
				new MemberMapper());
		if (list.size()==1) {
			student = list.get(0);
		}		
		return student;
	}

	public Integer delete(Integer pk) {
		int count = 0;
		String SQL = "delete from SpringMember where pk = ?";
		jdbcTemplateObject.update(SQL, pk);
		count++;
		System.out.println("刪除記錄, 主鍵  = " + pk);
		return count;
	}

	public Integer update(Member member) {
		int count = 0;
		String SQL = "update SpringMember set  password = ?, "
				+ "name = ?, email = ?, birthday =?, registerDate =?, experience = ? where userId = ?";
		jdbcTemplateObject.update(SQL, member.getPassword(), 
				member.getName(), member.getEmail(), 
				member.getBirthday(), member.getRegDate(), 
				member.getExperience(), member.getUserId()
		);
		count++;
		System.out.println("刪除記錄, account  = " + member.getUserId());
		return count;
	}

	@Override
	public List<Member> getAll() {
		String SQL = "select * from SpringMember";
		List<Member> members = jdbcTemplateObject
				.query(SQL, new MemberMapper());
		return members;
	}
	// SpringMember : 
	/*
	  String sqlCreateBLOBTable =
	 "CREATE TABLE SpringMember (PK int PRIMARY KEY auto_increment, "
	 + " userId varchar(32), password varchar(32), name varchar(32), email varchar(64), "
	 + " tel  varchar(15), experience int) "
	 + " ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci";
	 */
	public void createTable(String sql){
		int count = jdbcTemplateObject.update(sql);
		System.out.println("新建表格OK, count = " + count);
	}
}
