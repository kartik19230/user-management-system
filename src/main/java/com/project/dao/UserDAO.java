package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.model.User;

public class UserDAO {
	
	public static int save(User user) {
		
		int result = 0;
		String url = "jdbc:postgresql://localhost:5432/Dummy?user=postgres&password=root";
		String query = "INSERT INTO newform(name, age, email, phone, password) VALUES(?,?,?,?,?)";
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection(url)) {
			
			PreparedStatement pstm = con.prepareStatement(query);
			
			pstm.setString(1, user.getName());
			pstm.setInt(2, user.getAge());
			pstm.setString(3, user.getEmail());
			pstm.setLong(4, user.getPhone());
			pstm.setString(5, user.getPassword());
			
			result = pstm.executeUpdate();
			System.out.println("Rows inserted = " + result);
			
		} catch (SQLException e) {
		    System.out.println("DB ERROR: " + e.getMessage());
		    e.printStackTrace();
		}
		
		return result;
	}

}
