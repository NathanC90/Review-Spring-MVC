package ch02._01_setter._03.sqlserver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppDropAndCreateTable {
	public static void main(String[] args) {
        // 新建MemberExample表格 : 
		String createTableSQL =
		"CREATE TABLE MemberExample (PK int PRIMARY KEY IDENTITY, "
		+ " account varchar(32), password varchar(32), name varchar(32), "
		+ " email varchar(64), tel  varchar(15), experience int) ";
		 
		String dropTableSQL = "IF OBJECT_ID('dbo.MemberExample', 'U') IS NOT NULL DROP TABLE dbo.MemberExample; " ;

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"ch02/_01_setter/_03/sqlserver/Beans.xml");
		MemberJDBCTemplate memberJDBCTemplate =  
		           context.getBean(MemberJDBCTemplate.class);
		memberJDBCTemplate.createTable(dropTableSQL);
		memberJDBCTemplate.createTable(createTableSQL);
		((ConfigurableApplicationContext)context).close();
	}
}
