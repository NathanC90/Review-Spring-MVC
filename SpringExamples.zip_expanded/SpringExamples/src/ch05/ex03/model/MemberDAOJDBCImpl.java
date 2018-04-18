package ch05.ex03.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ch05.ex00.model.Member;
import ch05.ex00.model.MemberDAO;

public class MemberDAOJDBCImpl  implements MemberDAO{
	private DataSource dataSource = null;

	public MemberDAOJDBCImpl() {

	}
	public MemberDAOJDBCImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource(){
		return dataSource;
	}

	public boolean idExists(String id) {
		boolean exist = false;
		String sql = "SELECT * from  memberExample where userID = ?";
		DataSource ds = getDataSource();
		try(
			Connection conn = ds.getConnection();		
			PreparedStatement stmt = conn.prepareStatement(sql);	
		) {
			stmt.setString(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				exist = true;
			}
			
		}  catch (SQLException e) {
			e.printStackTrace();
		}		
		return exist;
	}
	// 新增一筆Member紀錄
	// SQL Server / MySQL
	public Integer save(Member mem) {
		String sqlSqlserver = "Insert into memberExample values(?, ?, ?, ?, ?, ?, ?)";
		String sqlMySQL     = "Insert into memberExample values(null, ?, ?, ?, ?, ?, ?, ?)";
		String sql = sqlSqlserver;
		int n = 0;
		DataSource ds = getDataSource();
		try(
			Connection conn = ds.getConnection();		
			PreparedStatement stmt = conn.prepareStatement(sql);	
		) {
			
			stmt.setString(1, mem.getUserId());
			stmt.setString(2, mem.getPassword());
			stmt.setString(3, mem.getName());
			stmt.setString(4, mem.getEmail());
			stmt.setDate(5, mem.getBirthday());
			stmt.setInt(6, mem.getExperience());
			stmt.setTimestamp(6, mem.getRegDate());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} 
		return n;
	}
	// 查詢一筆Member紀錄
	public Member get(Integer pk) {
		Member member = null;
		String sql = "Select * from memberExample where pk = ?";
		DataSource ds = getDataSource();
		try(
			Connection conn = ds.getConnection();		
			PreparedStatement stmt = conn.prepareStatement(sql);	
		) {
			stmt.setInt(1, pk);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()){
				member = new Member(
					 rset.getInt("pk"),
					 rset.getString("userId"),
					 rset.getString("password"),
					 rset.getString("name"),
					 rset.getString("email"),
					 rset.getDate("birthday"),
					 rset.getTimestamp("registerDate"),
					 rset.getInt("experience"));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
		return member;
	}
	// 更新一筆Member紀錄
	public Integer update(Member mem) {
		int count = 0;
		String sql = "Update memberExample set userId=?, password=?, name=?, email=?, birthday=?, registerDate, experience=? where pk = ?";
		DataSource ds = getDataSource();
		try(
			Connection conn = ds.getConnection();		
			PreparedStatement stmt = conn.prepareStatement(sql);	
		) {
			stmt.setString(1, mem.getUserId());
			stmt.setString(2, mem.getPassword());
			stmt.setString(3, mem.getName());
			stmt.setString(4, mem.getEmail());
			stmt.setDate(5, mem.getBirthday());
			stmt.setTimestamp(6, mem.getRegDate());
			stmt.setInt(7, mem.getExperience());
			stmt.setInt(8, mem.getPk());
			count = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return count;
	}
	// 刪除一筆Member紀錄
	public Integer delete(Integer pk) {
		int count = 0;
		DataSource ds = getDataSource();
		String sql = "Delete From memberExample where pk = ?";
		try(
			Connection conn = ds.getConnection();		
			PreparedStatement stmt = conn.prepareStatement(sql);	
		) {
			stmt.setInt(1, pk);
			count = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	// 查詢多筆Member紀錄
	public List<Member> getAll() {
		String sql = "SELECT * from  memberExample";
		List<Member> allMembers = new ArrayList<Member>();
		DataSource ds = getDataSource();
		try(
			Connection conn = ds.getConnection();		
			PreparedStatement stmt = conn.prepareStatement(sql);	
			ResultSet rset = stmt.executeQuery();
		) {
			Member mem = null;
			while (rset.next()) {
				mem = new Member(
						 rset.getInt("pk"),
						 rset.getString("userId"),
						 rset.getString("password"),
						 rset.getString("name"),
						 rset.getString("email"),
						 rset.getDate("birthday"),
						 rset.getTimestamp("registerDate"),
						 rset.getInt("experience"));
				allMembers.add(mem);
			}
			return allMembers;
		}  catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;	
	}
	
}