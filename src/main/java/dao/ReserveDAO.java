package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ReserveBean;

public class ReserveDAO {
	
	private final String JDBC_URL = "jdbc:mysql://localhost/reservation";
	private final String DB_USER = "root";
	private final String DB_PASS = "password";
	
	public List<ReserveBean> findAll() {
		
		List<ReserveBean> reserveList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "select reserve_id, reserve_person, reserve_date, purpose, start_usagetime, end_usagetime "
					+ "from reserve where reserve_date >= curdate() order by reserve_date desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("reserve_id");				
				String userName = rs.getString("reserve_person");
				String date = rs.getString("reserve_date");
				String text = rs.getString("purpose");
				String start = rs.getString("start_usagetime");
				String end = rs.getString("end_usagetime");
				ReserveBean rb = new ReserveBean(id, userName, date, text, start, end);
				reserveList.add(rb);
			}			
			
		} catch (SQLException e){
			e.printStackTrace();
			return null;			
		}
		return reserveList;
		
	}	
	
	public boolean reserveCheck(ReserveBean rb) {
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "select * from reserve where reserve_date = ? and end_usagetime > ? and start_usagetime < ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, rb.getDate());
			ps.setString(2, rb.getStart());
			ps.setString(3, rb.getEnd());			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return false;
			} else if (rb.getStart().equals(rb.getEnd())){
				return false;
			} else {			
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;			
		}
		
	}
	
	public boolean reserve(ReserveBean rb) {
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			String sql = "insert into reserve"
					+ "(reserve_person, reserve_date, purpose, start_usagetime, end_usagetime) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, rb.getUserName());
			ps.setString(2, rb.getDate());
			ps.setString(3, rb.getText());
			ps.setString(4, rb.getStart());
			ps.setString(5, rb.getEnd());
			
			int result = ps.executeUpdate();
			if(result != 1) {
				return false;
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
			return false;			
		}
		return true;
	}
	
	public boolean updateReserveCheck(int id, String date, String text, String start, String end) {
		
		try  (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "select * from reserve where reserve_id = ? and reserve_date = ? and purpose = ?"
					+ " and start_usagetime = ? and end_usagetime = ?";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.setString(2, date);
			ps.setString(3, text);
			ps.setString(4, start);
			ps.setString(5, end);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return false;
			} else {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean update(int id, String date, String text, String start, String end) {
		
		try  (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			String sql = "update reserve set reserve_date = ?, purpose = ?, "
					+ "start_usagetime = ?, end_usagetime = ? where reserve_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// UPDATE文中の「?」に使用する値を設定しSQLを完成
			ps.setString(1, date);
			ps.setString(2, text);
			ps.setString(3, start);
			ps.setString(4, end);
			ps.setInt(5, id);
			
			// UPDATE文を実行
			int result = ps.executeUpdate();
			
			if (result != 1) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(int id) {
		// データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// DELETE文の準備
			String sql = "DELETE FROM reserve WHERE reserve_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// DELETE文中の「?」に使用する値を設定しSQLを完成
			pStmt.setInt(1, id);

			// DELETE文を実行
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
