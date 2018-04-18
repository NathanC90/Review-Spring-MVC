package ch04.sqlserver._03.jdbcTemplate.anno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ch04._00.model.Member;
import ch04._00.model.MemberDAO;
import ch04._00.model.MemberMapper;
@Repository
public class MemberJDBCTemplate implements MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

//	public MemberJDBCTemplate(JdbcTemplate template) {
//		this.jdbcTemplateObject = template;
//	}
	public MemberJDBCTemplate() {
	}

	public Integer save(Member member) {
		int count = 0 ;
		String SQL = "insert into SpringMember "
				+ " (userId, password, name, email, birthday, registerDate, experience) "
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
		Member student = null;
		try {
		     student = jdbcTemplateObject.queryForObject(SQL,
				new Object[] { pk }, new MemberMapper());
		} catch(org.springframework.dao.EmptyResultDataAccessException ex) {
			;
		}     
		return student;
//      另外一種做法: 		
//		Member student = null;
//		List<Member> list = jdbcTemplateObject.query(SQL,
//				new Object[] { pk }, new int[]{java.sql.Types.INTEGER}, 
//				new MemberMapper());
//		if (list.size()==1) {
//			student = list.get(0);
//		}		
//		return student;
	}

	public Member betterGet(Integer pk) {
		String SQL = "select * from SpringMember where pk = ?";
		RowMapper<Member> rowMapper = new BeanPropertyRowMapper<>(Member.class);
		Member student = null;
		try {
		     student = jdbcTemplateObject.queryForObject(SQL, rowMapper, pk);
		} catch(org.springframework.dao.EmptyResultDataAccessException ex) {
			;
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
				+ "name = ?, email = ?, birthday =?, experience = ? where userId = ?";
		jdbcTemplateObject.update(SQL, member.getPassword(), 
				member.getName(), member.getEmail(), 
				member.getBirthday(),
				member.getExperience(), member.getUserId()
		);
		count++;
		System.out.println("修改記錄, account  = " + member.getUserId());
		return count;
	}

	@Override
	public List<Member> getAll() {
		String SQL = "select * from SpringMember";
		List<Member> members = jdbcTemplateObject
				.query(SQL, new MemberMapper());
		return members;
	}
	
	public void createTable(String sql){
		int count = jdbcTemplateObject.update(sql);
		System.out.println("新建表格OK, count = " + count);
	}
}
