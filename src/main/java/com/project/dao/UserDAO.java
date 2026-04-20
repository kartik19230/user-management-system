package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.model.User;

public class UserDAO {
	
	public static Connection getConnection(){
		
		Connection con = null;
		
		String url = "jdbc:postgresql://localhost:5432/Dummy?user=postgres&password=root";
		String driver = "org.postgresql.Driver";
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static int save(User user) {
		
		int result = 0;
		
		String query = "INSERT INTO newform(name, age, email, phone, password) VALUES(?,?,?,?,?)";
		
		
		
		try(Connection con = getConnection()) {
			
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
	
	public static User login(String email,String password){
		
		User user = null;
		
		String query = "SELECT * FROM newform WHERE email = ? AND password = ?";
		
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(query)){
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				 user = new User(
						 	rs.getString("name"),
						 	rs.getInt("age"),
						 	rs.getString("email"),
						 	rs.getLong("phone"),
						 	null);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}

}
