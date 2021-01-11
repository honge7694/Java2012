package com.swcodingschool.guibasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 데이터베이스 연결과 관련한 메서드를 정의하는 클래스
 */
public class DBUtil {
	static final String JDBCDRV = "com.mysql.cj.jdbc.Driver"; // 정해져있는 것.
	static final String URL = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static final String DBUSER = "java"; // 집에서는 root 학원에서는 java
	static final String DBPASSWD = "1234";
	
	static Connection dbconn = null;
	
	public static void DBConnect() {
		try {
			// step1. 드라이버 로드
			Class.forName(JDBCDRV);
			System.out.println("[MyMSG]JDBC 드라이버를 정상적으로 로드하였습니다.");
			
			// step2. 데이터베이스 연결
			dbconn = DriverManager.getConnection(URL, DBUSER, DBPASSWD);
			
		} catch (ClassNotFoundException e) {
			System.out.println("[MyMSG]JDBC 드라이버를 정상적으로 로드하지 못하였습였습니다.");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("[MyMSG]데이터베이스 연결에 실패하였습니다.");
			e.printStackTrace();
		}
	} // end of DBConnect()
	
	public static void DBClose() {
		try {
			dbconn.close();
			System.out.println("[MyMSG]데이터베이스 연결을 종료하였습니다.");
		}catch(SQLException e){
			System.out.println("[MyMSG]데이터베이스 연결을 종료하지 못하였습니다.");
			e.printStackTrace();
		}
	} // end of DBClose()
	
} // end of class
