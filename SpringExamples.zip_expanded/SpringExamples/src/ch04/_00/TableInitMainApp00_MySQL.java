package ch04._00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
    本程式使用JDBC的傳統作法，展示JDBC繁多且複雜的特定。
*/
public class TableInitMainApp00_MySQL {
	public static void main(String[] args) {
        // 新建Customer表格 : 
		String createTableSQL =
		"CREATE TABLE SpringMember ("
		+ " pk INT PRIMARY KEY Auto_Increment, "
		+ " userId 		VARCHAR(32), "
		+ " password 	VARCHAR(32), "
		+ " name 		VARCHAR(32), "  
		+ " email  		VARCHAR(50), "
		+ " birthday	Date, "
		+ " registerDate	DateTime DEFAULT CURRENT_TIMESTAMP, "
		+ " experience  INT(2) "
		+ ") "
		+ " ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci";
		 
		String dropTableSQL = "DROP TABLE IF EXISTS SpringMember;" ;
		String url = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "password";
        try (
		   Connection conn = DriverManager.getConnection(url, user, password);
           PreparedStatement stmtd = conn.prepareStatement(dropTableSQL);
           PreparedStatement stmtc = conn.prepareStatement(createTableSQL);
		) {
        	stmtd.executeUpdate();	// DROP TABLE IF EXISTS 
        	stmtc.executeUpdate();	// CREATE TABLE 
        	System.out.println("表格新建成功-MySQL");
        } catch(SQLException ex){
        	System.out.println("表格新建失敗-MySQL");
        	ex.printStackTrace();
        }
	}
}
