package com.chw.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Template {
	
	/*
	 * Template Class
	 * 	=> JDBC과정중 반복적으로 쓰이는 구문들을 각각의 메소드로 정의해두는 폴더 (재사용의 목적)
	 */
	
	/**
	 * Connection 객체 생성 및 JDBC 드라이버와 연결하는 메소드
	 * @return 
	 */
	public static Connection getConnection() {
		
		Connection conn = null;
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
			
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("URL"),
											   prop.getProperty("ID"), 
											   prop.getProperty("PWD"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// Connection 객체의 트랜션을 담당하는 메소드
	// 항상 conn이 제대로 들어왔는지를 확인하기 위하여 if문을 사용해 조건을 걸어준다.
	// 조건 : 1. conn이 비어있지 않은 경우 == (conn != null)
	//		 2. conn이 닫혀있지 않은 경우 == (!conn.isClosed())

	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.setAutoCommit(false);
				conn.commit();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {				
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * close()
	 * -> 메소드 오버로딩을 통해 재정의 됨
	 * -> Connection, Statement, ResultSet 객체들을 닫아준다
	 */
	
	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {				
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rSet) {
		try {
			if (rSet != null && !rSet.isClosed()) {				
				rSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
