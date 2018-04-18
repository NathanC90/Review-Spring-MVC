package ch04.sqlserver._03.jdbcTemplate;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch04._00.model.Member;

public class MainAppQuery {

	public static void main(String[] args) {
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"\\ch04\\sqlserver\\_03\\jdbcTemplate\\Beans_SQLServer.xml");

		MemberJDBCTemplate memberJDBCTemplate =  
				           context.getBean(MemberJDBCTemplate.class);

		
		System.out.println("------顯示多筆記錄 --------");
		List<Member> members = memberJDBCTemplate.getAll();
		for (Member member : members) {
			System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n", 
					member.getUserId(), member.getPassword(), member.getName(), 
					member.getEmail(), member.getBirthday(), member.getRegDate(), member.getExperience()
					);
		}

		System.out.println("----顯示單筆記錄 PK = 2 -----");
		Member member = memberJDBCTemplate.betterGet(2);
		displayMember(member);
		
		System.out.println("----顯示單筆記錄 PK = 200 -----");
		member = memberJDBCTemplate.betterGet(200);
		displayMember(member);
		
		((ConfigurableApplicationContext)context).close();
	}
	static void displayMember(Member member) {
		if (member != null) {
			System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n",
				member.getUserId(), member.getPassword(),
				member.getName(), member.getEmail(),
				member.getBirthday(), member.getRegDate(),
				member.getExperience());
		} else {
			System.out.println("===>查無此筆記錄");
		}
		System.out.println("------------------------------");
	}
}
