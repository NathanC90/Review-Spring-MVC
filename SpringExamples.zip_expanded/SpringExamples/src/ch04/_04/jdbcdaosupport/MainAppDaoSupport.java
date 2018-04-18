package ch04._04.jdbcdaosupport;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch04._00.model.Member;

public class MainAppDaoSupport {

	public static void main(String[] args) {
		Member m1 = new Member("kittyDAO", "111", "周亞萍", "kitty6655@gmail.com",
				java.sql.Date.valueOf("1983-03-14"), new Timestamp(System.currentTimeMillis()),10);
		Member m2 = new Member("mickyDAO", "222", "米奇潔", "micky99512@gmail.com",
				java.sql.Date.valueOf("1979-07-20"), new Timestamp(System.currentTimeMillis()),5);
		Member m3 = new Member("snoopyDAO", "333", "史努比", "snoopy71023@gmail.com",
				java.sql.Date.valueOf("1976-09-01"), new Timestamp(System.currentTimeMillis()),0);
		Member[] ma = {m1, m2, m3};
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ch04/_04/jdbcdaosupport/Beans.xml");

		MemberJDBCDaoSupport daoSupport =  
				           context.getBean(MemberJDBCDaoSupport.class);

		System.out.println("------ 新增記錄--------");
		for(Member member : ma){
			daoSupport.save(member);
        }

		System.out.println("------顯示多筆記錄 --------");
		List<Member> members = daoSupport.getAll();
		for (Member member : members) {
			System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n", 
					member.getUserId(), member.getPassword(), member.getName(), 
					member.getEmail(), member.getBirthday(), member.getRegDate(), member.getExperience()
					);
		}

		System.out.println("----更新紀錄userId = mickyDAO -----");
		Member mu = new Member("mickyDAO", "new_pswd", "米篠婕", "micky20110203@gmail.com",
				java.sql.Date.valueOf("1977-12-26"), new Timestamp(System.currentTimeMillis()),3);
		daoSupport.update(mu);

		System.out.println("----顯示單筆記錄 PK = 2 -----");
		Member member = daoSupport.get(2);
		
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
		daoSupport.delete(3);
		
		System.out.println("------刪除後再顯示多筆記錄 --------");
		List<Member> membersA = daoSupport.getAll();
		
		for (Member memberA : membersA) {
			System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n", 
					memberA.getUserId(), memberA.getPassword(), memberA.getName(), 
					memberA.getEmail(), memberA.getBirthday(), memberA.getRegDate(), memberA.getExperience()
					);
		}		
		
		((ConfigurableApplicationContext)context).close();
	}
}
