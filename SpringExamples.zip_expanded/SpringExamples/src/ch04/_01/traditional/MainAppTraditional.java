package ch04._01.traditional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import ch04._00.model.Member;
/*
 * 傳統JDBC的url = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8";
 * Spring的  url = "jdbc:mysql://localhost:3306/jspdb&amp;useUnicode=true&characterEncoding=utf8&amp;verifyServerCertificate=false&amp;useSSL=true";
 */
public class MainAppTraditional {
	public static void main(String[] args) {
		Member m1 = new Member("kittyTrad", "111", "周亞萍", "kitty123@gmail.com",
				java.sql.Date.valueOf("1995-12-20"), new Timestamp(System.currentTimeMillis()),10);
		Member m2 = new Member("mickyTrad", "222", "米奇潔", "micky456@gmail.com",
				java.sql.Date.valueOf("1988-07-31"), new Timestamp(System.currentTimeMillis()),5);
		Member m3 = new Member("snoopyTrad", "333", "史努比", "snoopy789@gmail.com",
				java.sql.Date.valueOf("1972-03-07"), new Timestamp(System.currentTimeMillis()),0);
		Member[] ma = {m1, m2, m3};
		
		MemberJDBCTraditional memTrad = new MemberJDBCTraditional(); 
		System.out.println("------ 新增記錄--------");
        for(Member member : ma){
        	memTrad.save(member);
        }

		System.out.println("------顯示多筆記錄 --------");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Member> members = memTrad.getAll();
		for (Member member : members) {
			System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n", 
					member.getUserId(), member.getPassword(), member.getName(), 
					member.getEmail(), member.getBirthday(), member.getRegDate(), member.getExperience()
					);
		}

		System.out.println("----更新紀錄: userId = mickyTrad -----");
		Member mu = new Member("mickyTrad", "new_pswd", "米小潔", "micky998877@gmail.com",
				java.sql.Date.valueOf("1981-06-21"), new Timestamp(System.currentTimeMillis()),3);
		memTrad.update(mu);

		System.out.println("----顯示單筆記錄 PK = 2 -----");
		Member member = memTrad.get(2);
		System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n", 
				member.getUserId(), member.getPassword(), member.getName(), 
				member.getEmail(), member.getBirthday(), member.getRegDate(), member.getExperience()
				);
		
		System.out.println("----刪除紀錄 PK = 3 -----");
		memTrad.delete(3);
		
		System.out.println("------刪除後再顯示多筆記錄 --------");
		List<Member> membersA = memTrad.getAll();
		for (Member memberA : membersA) {
			System.out.printf("Account: %-10s, Passwword: %-10s, Name: %-6s, Email: %-25s, 生日: %10s, 注冊時間:  %20s, 經驗:%2d\n", 
					memberA.getUserId(), memberA.getPassword(), memberA.getName(), 
					memberA.getEmail(), memberA.getBirthday(), memberA.getRegDate(), memberA.getExperience()
					);
		}		
	}
}
