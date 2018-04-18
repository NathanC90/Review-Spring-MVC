package ch04.sqlserver._00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
    本程式使用JDBC的傳統作法，展示JDBC繁多且複雜的特定。
*/
public class TableInitMainApp00_SQLServer {
	public static void main(String[] args) {
        // 新建Customer表格 : 
		String createTableSQL =
		"CREATE TABLE SpringMember ("
		+ " pk INT PRIMARY KEY IDENTITY, "
		+ " userId 		VARCHAR(32), "
		+ " password 	VARCHAR(32), "
		+ " name 		VARCHAR(32), "  
		+ " email  		VARCHAR(50), "
		+ " birthday	Date, "
		+ " registerDate	DateTime NOT NULL DEFAULT GETDATE(), "
		+ " experience  INTEGER "
		+ ") ";
		 
		String dropTableSQL = "IF OBJECT_ID('dbo.SpringMember', 'U') IS NOT NULL " + 
							  "  DROP TABLE dbo.SpringMember;" ;
		String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=jspdb";
		String user = "sa";
		String password = "sa123456";
        try (
		   Connection conn = DriverManager.getConnection(url, user, password);
           PreparedStatement stmtd = conn.prepareStatement(dropTableSQL);
           PreparedStatement stmtc = conn.prepareStatement(createTableSQL);
		) {
        	stmtd.executeUpdate();	// DROP TABLE IF EXISTS 
        	stmtc.executeUpdate();	// CREATE TABLE 
        	System.out.println("表格新建成功-SQL Server");
        } catch(SQLException ex){
        	System.out.println("表格新建失敗-SQL Server");
        	ex.printStackTrace();
        }
	}
}
