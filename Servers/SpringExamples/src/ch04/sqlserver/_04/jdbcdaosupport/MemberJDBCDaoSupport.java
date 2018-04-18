package ch04.sqlserver._04.jdbcdaosupport;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import ch04._00.model.Member;
import ch04._00.model.MemberDAO;
import ch04._00.model.MemberMapper;

public class MemberJDBCDaoSupport extends JdbcDaoSupport implements MemberDAO {

//	private JdbcTemplate jdbcTemplateObject;
//
//	public MemberJDBCDaoSupport(JdbcTemplate template) {
//		this.jdbcTemplateObject = template;
//	}

	public Integer save(Member member) {
		int count = 0 ;
		String SQL = "insert into SpringMember "
				+ " ( userId, password, name, email, birthday, registerDate, experience) "
				+ " values ( ?, ?, ?, ?, ?, ?, ?)";
//		jdbcTemplateObject.update(SQL, member.getUserId(),
//				member.getPassword(), member.getName(), 
//				member.getEmail(), member.getBirthday(), 
//				member.getRegDate(), member.getExperience()
//			);
		getJdbcTemplate().update(SQL, member.getUserId(),
				member.getPassword(), member.getName(), 
				member.getEmail(), member.getBirthday(), 
				member.getRegDate(), member.getExperience());		
		count++;
		System.out.println("新建會員資料成功");
		return count;
	}

	public Member get(Integer pk) {
		String SQL = "select * from SpringMember where pk = ?";
//      如果確定有該筆記錄:		
//		Member student = jdbcTemplateObject.queryForObject(SQL,
//				new Object[] { pk }, new MemberMapper());
//  --------------------------------------------------------------		
//      如果確定有該筆記錄:		
//		Member student = getJdbcTemplate().queryForObject(SQL,
//		new Object[] { pk }, new MemberMapper());
//		return student;
//      如果不確定是否有該筆記錄: 		
		Member student = null;
		List<Member> list = getJdbcTemplate().query(SQL,
				new Object[] { pk }, new int[]{java.sql.Types.INTEGER}, new MemberMapper());
		if (list.size()==1) {
			student = list.get(0);
		}		
		return student;		
	}

	public Integer delete(Integer pk) {
		int count = 0;
		String SQL = "delete from SpringMember where pk = ?";
		getJdbcTemplate().update(SQL, pk);
		count++;
		System.out.println("刪除記錄, 主鍵  = " + pk);
		return count;
	}

	public Integer update(Member member) {
		int count = 0;
		String SQL = "update SpringMember set  password = ?, "
				+ "name = ?, email = ?, birthday =?, registerDate =?, experience = ? where userId = ?";
		getJdbcTemplate().update(SQL, member.getPassword(),	member.getName(), 
				member.getEmail(), member.getBirthday(), member.getRegDate(), 
				member.getExperience(), member.getUserId()
		);
		count++;
		System.out.println("刪除記錄, account  = " + member.getUserId());
		return count;
	}

	@Override
	public List<Member> getAll() {
		String SQL = "select * from SpringMember";
		List<Member> members = getJdbcTemplate()
				.query(SQL, new MemberMapper());
		return members;
	}
	
	public void createTable(String sql){
		int count = getJdbcTemplate().update(sql);
		System.out.println("新建表格OK, count = " + count);
	}
}
