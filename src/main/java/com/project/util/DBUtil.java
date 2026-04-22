package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static String url = "jdbc:postgresql://localhost:5432/Dummy?user=postgres&password=root";
	private static String driver = "org.postgresql.Driver";
	
	static {
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException{
	
		return DriverManager.getConnection(url);	
	}
}
