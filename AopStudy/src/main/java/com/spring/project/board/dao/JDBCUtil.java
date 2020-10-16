package com.spring.project.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	// Connection객체를 리턴받는 메소드
	public static Connection getConnection() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "MYDB", "oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	//할당받은 커넥션 정보를 해제하는 메소드
	public static void close(PreparedStatement stmt, Connection conn) {
		// PreparedStatement : 쿼리 실행기
		// Connection : 접속 정보
		
		if(stmt != null) { // 접속이 되어 있으면
			try {
				if(!stmt.isClosed()) { // 닫혀있지 않다면
					stmt.close(); // 닫으셈
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally { // 무적권 실행
				stmt = null;  // 닫으셈
			}
		}
		if(conn != null) { // 접속이 되어 있으면
			try {
				if(!conn.isClosed()) { // 닫혀있지 않다면
					conn.close(); // 닫으셈
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally { // 무적권 실행
				conn = null;  // 닫으셈
			}
		}
		
	}
	
	//할당받은 커넥션 정보를 해제하는 메소드
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		// ResultSet : select 결과 그릇
		// PreparedStatement : 쿼리 실행기
		// Connection : 접속 정보
		
		if(rs != null) { // 접속이 되어 있으면
			try {
				if(!rs.isClosed()) { // 닫혀있지 않다면
					rs.close(); // 닫으셈
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally { // 무적권 실행
				rs = null;  // 닫으셈
			}
		}
		if(stmt != null) { // 접속이 되어 있으면
			try {
				if(!stmt.isClosed()) { // 닫혀있지 않다면
					stmt.close(); // 닫으셈
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally { // 무적권 실행
				stmt = null;  // 닫으셈
			}
		}
		if(conn != null) { // 접속이 되어 있으면
			try {
				if(!conn.isClosed()) { // 닫혀있지 않다면
					conn.close(); // 닫으셈
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally { // 무적권 실행
				conn = null;  // 닫으셈
			}
		}
		
	}
	
	
	
	
	
	
}
