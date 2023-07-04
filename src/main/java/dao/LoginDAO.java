package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class LoginDAO {
	
	private final String JDBC_URL = "jdbc:mysql://localhost/reservation";
	private final String DB_USER = "root";
	private final String DB_PASS = "password";
	
	public User loginCheck(User user) {
		User userCheck = new User();
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "select * from account where mail = ? and pass = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, user.getMail());
			pStmt.setString(2, user.getPass());
			
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				// 見つかったアカウント情報を戻り値にセット
				userCheck.setUserType(rs.getInt("user_type"));
				userCheck.setName(rs.getString("name"));
				userCheck.setMail(rs.getString("mail"));
				userCheck.setPass(rs.getString("pass"));
				
			} else {
				// アカウントがなければnullを返す
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userCheck;
		
	}
	
	public boolean newUserCheck(User user) {
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "select * from account where name = ?";
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return false;
			} else {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		
	}
	
	public boolean register(User user) {
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "insert into account(user_type, name, mail, pass) values(?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, user.getUserType());
			pStmt.setString(2, user.getName());
			pStmt.setString(3, user.getMail());
			pStmt.setString(4, user.getPass());
			
			int result = pStmt.executeUpdate();
			
			if (result != 1) {
				return false;
			  }			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;	
		
	}

}
