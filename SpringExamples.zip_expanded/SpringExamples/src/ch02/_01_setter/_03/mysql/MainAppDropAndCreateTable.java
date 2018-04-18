package ch02._01_setter._03.mysql;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppDropAndCreateTable {
	public static void main(String[] args) {
        // 新建MemberExample表格 : 
		String createTableSQL =
		"CREATE TABLE MemberExample (PK int PRIMARY KEY auto_increment, "
		+ " account varchar(32), password varchar(32), name varchar(32), "
		+ " email varchar(64), tel  varchar(15), experience int) "
		+ " ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci";
		 
		String dropTableSQL = "DROP TABLE IF EXISTS MemberExample; " ;

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ch02/_01_setter/_03/mysql/Beans.xml");
		MemberJDBCTemplate memberJDBCTemplate =  
		           context.getBean(MemberJDBCTemplate.class);
		memberJDBCTemplate.createTable(dropTableSQL);
		memberJDBCTemplate.createTable(createTableSQL);
	}

}
