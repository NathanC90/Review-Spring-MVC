package ch04.sqlserver._03.jdbcTemplate.anno;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch04._00.model.Member;

public class MainAppTemplate {

	public static void main(String[] args) {
		Member m1 = new Member("kittyTemp", "111", "周亞萍", "kitty123@gmail.com",
				java.sql.Date.valueOf("1995-12-20"), new Timestamp(System.currentTimeMillis()),10);
		Member m2 = new Member("mickyTemp", "222", "米奇潔", "micky456@gmail.com",
				java.sql.Date.valueOf("1988-07-31"), new Timestamp(System.currentTimeMillis()),5);
		Member m3 = new Member("snoopyTemp", "333", "史努比", "snoopy789@gmail.com",
				java.sql.Date.valueOf("1972-03-07"), new Timestamp(System.currentTimeMillis()),0);
		Member[] ma = {m1, m2, m3};
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ch04\\sqlserver\\_03\\jdbcTemplate\\anno\\Beans_SQLServer.xml");

		MemberJDBCTemplate memberJDBCTemplate =  
				           context.getBean(MemberJDBCTemplate.class);

		System.out.println("------ 新增記錄--------");
		for(Member member : ma){
			memberJDBCTemplate.save(member);
        }
		
		System.out.println("------顯示多筆記錄 --------");
		List<Member> members = memberJDBCTemplate.getAll();
		for (Member member : members) {
			System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n", 
					member.getUserId(), member.getPassword(), member.getName(), 
					member.getEmail(), member.getBirthday(), member.getRegDate(), member.getExperience()
					);
		}

		System.out.println("----更新紀錄 userId = mickyTemp -----");
		Member mu = new Member("mickyTemp", "new_pswd", "米筱潔", "micky002001@gmail.com",
				java.sql.Date.valueOf("1979-02-03"), new Timestamp(System.currentTimeMillis()),3);
		memberJDBCTemplate.update(mu);

		System.out.println("----顯示單筆記錄 PK = 2 -----");
		Member member = memberJDBCTemplate.get(2);

		if (member != null) {
			System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n",
				member.getUserId(), member.getPassword(),
				member.getName(), member.getEmail(),
				member.getBirthday(), member.getRegDate(),
				member.getExperience());
		} else {
			System.out.println("===>查無此筆記錄(PK = 2)");
		}
		
		System.out.println("----刪除紀錄 PK = 3 -----");
		memberJDBCTemplate.delete(3);
		
		System.out.println("------刪除後再顯示多筆記錄 --------");
		List<Member> membersA =  memberJDBCTemplate.getAll();
		for (Member memberA : membersA) {
			System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n", 
					memberA.getUserId(), memberA.getPassword(), memberA.getName(), 
					memberA.getEmail(), memberA.getBirthday(), memberA.getRegDate(), memberA.getExperience()
					);
		}		
		((ConfigurableApplicationContext)context).close();
	}
}
