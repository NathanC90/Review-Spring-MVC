package ch04._02.datasourcesupport;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch04._00.model.Member;
/*
 * 傳統JDBC的url = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8";
 * Spring的  url = "jdbc:mysql://localhost:3306/jspdb&amp;useUnicode=true&characterEncoding=utf8";
 */
public class MainAppDataSource {
	public static void main(String[] args) {
		Member m1 = new Member("kittyC3P0", "ABC", "劉麗芳", "timeline@gmail.com",
				java.sql.Date.valueOf("1987-2-13"), new Timestamp(System.currentTimeMillis()),10);
		Member m2 = new Member("mickyC3P0", "258", "史東華", "pinkysee@gmail.com",
				java.sql.Date.valueOf("1976-01-26"), new Timestamp(System.currentTimeMillis()),5);
		Member m3 = new Member("snoopyC3P0", "xyz", "黃國偉", "opiusdd@gmail.com",
				java.sql.Date.valueOf("1972-05-08"), new Timestamp(System.currentTimeMillis()),0);
		Member[] ma = {m1, m2, m3};
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("ch04/_02/datasourcesupport/Beans.xml");
		
		MemberJDBCDataSource memDS = context.getBean(MemberJDBCDataSource.class); 
		System.out.println("------ 新增記錄--------");
        for(Member member : ma){
        	memDS.save(member); 
        }

		System.out.println("------顯示多筆記錄 --------");
		List<Member> members = memDS.getAll();
		for (Member member : members) {
			System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n", 
					member.getUserId(), member.getPassword(), member.getName(), 
					member.getEmail(), member.getBirthday(), member.getRegDate(), member.getExperience()
					);
		}

		System.out.println("----更新紀錄: userId = mickyC3P0 -----");
		Member mu = new Member("mickyC3P0", "new_Pswd", "米曉潔", "mickyMe_2589@gmail.com",
				java.sql.Date.valueOf("1980-06-11"), new Timestamp(System.currentTimeMillis()),0);
		memDS.update(mu);

		System.out.println("----顯示單筆記錄 PK = 2 -----");
		Member member = memDS.get(2);
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
		memDS.delete(3);
		
		System.out.println("------刪除後再顯示多筆記錄 --------");
		List<Member> membersA = memDS.getAll();
		for (Member memberA : membersA) {
			System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n", 
					memberA.getUserId(), memberA.getPassword(), memberA.getName(), 
					memberA.getEmail(), memberA.getBirthday(), memberA.getRegDate(), memberA.getExperience()
					);
		}		
		((ConfigurableApplicationContext)context).close();
	}
}
