package test.model.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionDAO {
	
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			System.out.println("[1]");
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("[2]");
			String dbHost = "jdbc:mariadb://myrdstest.caeupn4gbsel.ap-northeast-2.rds.amazonaws.com:3306/innodb";
			System.out.println("[3]");
			String user = "masterUsername";
			System.out.println("[4]");
			String pass = "12345678";
			System.out.println("[5]");
			conn = DriverManager.getConnection(dbHost, user, pass);
			System.out.println("[DB 연결 성공]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn)
	{
		if(rs != null){try{rs.close();}catch(Exception e){e.printStackTrace();}}
		if(pstmt != null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
		if(conn != null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
	}
}
