package ch05.ex01.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ch05.ex00.model.Member;
import ch05.ex00.model.MemberDAO;
import ch05.ex00.model.MemberMapper;
@Repository
public class MemberDAOJdbcTemplate implements MemberDAO {
	@Autowired
	    JdbcTemplate template;
		public MemberDAOJdbcTemplate() {
		}
		public JdbcTemplate getTemplate() {
			return template;
		}
		public void setTemplate(JdbcTemplate template) {
			this.template = template;
		}
		// SQL_Serever / MySQL 
		public Integer save(Member member) {
			int count = 0 ;
			String SQL_MySQL = "insert into SpringMember "
			+ " (pk, userId, password, name, email, birthday, registerDate, experience) "
			+ " values (null, ?, ?, ?, ?, ?, ?, ?)";
			
			String SQL_SQLServer = "insert into SpringMember "
					+ " (userId, password, name, email, birthday, registerDate, experience) "
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			template.update(SQL_SQLServer, member.getUserId(),
					member.getPassword(), member.getName(), 
					member.getEmail(), member.getBirthday(), 
					member.getRegDate(), member.getExperience());		
			count++;
			System.out.println("新建會員資料成功");
			return count;
		}
		// JdbcTemplate類別的queryForInt, queryForLong, queryForObject: ㄧ定要剛好傳回ㄧ列，
		// 如果傳回0列或多列都會丟出 IncorrectResultSizeDataAccessException。
		@Override
		public boolean idExists(String id) {
			String SQL = "select * from SpringMember where userId = ?";

			List<Member> list = template.query(SQL, new Object[] { id }, new MemberMapper());
			if ( list.isEmpty() ){
			  return false;
			}else {
			  return true;
			}
		}
		
		public Member get(Integer pk) {
			String SQL = "select * from SpringMember where pk = ?";
			Member student = template.queryForObject(SQL,
			new Object[] { pk }, new MemberMapper());
			return student;
		}

		public Integer delete(Integer pk) {
			int count = 0;
			String SQL = "delete from SpringMember where pk = ?";
			template.update(SQL, pk);
			count++;
			System.out.println("刪除記錄, 主鍵  = " + pk);
			return count;
		}

		public Integer update(Member member) {
			int count = 0;
			String SQL = "update SpringMember set  password = ?, "
					+ "name = ?, email = ?, birthday =?, experience = ? where userId = ?";
			template.update(SQL, member.getPassword(), 
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
			List<Member> members = template.query(SQL, new MemberMapper());
			return members;
		}
		
	}