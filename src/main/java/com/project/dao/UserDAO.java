package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.project.model.User;
import com.project.util.DBUtil;

public class UserDAO {
	
	public static int save(User user) {
		
		int result = 0;
		
		String query = "INSERT INTO newform(name, age, email, phone, password) VALUES(?,?,?,?,?)";
		
		
		try(Connection con =  DBUtil.getConnection();
				PreparedStatement pstm = con.prepareStatement(query)){
			
			String hashedPassword = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
			
			pstm.setString(1, user.getName());
			pstm.setInt(2, user.getAge());
			pstm.setString(3, user.getEmail());
			pstm.setLong(4, user.getPhone());
			pstm.setString(5, hashedPassword);
			
			result = pstm.executeUpdate();
			System.out.println("Rows inserted = " + result);
			
		} catch (SQLException e) {
		    System.out.println("DB ERROR: " + e.getMessage());
		}
		
		return result;
	}
	
	public static User login(String email,String password){
		
		User user = null;
		
		String query = "SELECT * FROM newform WHERE email = ?";
		
		try(Connection con =  DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(query)){
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				String DBhash = rs.getString("password");
				
				if(BCrypt.checkpw(password, DBhash)) {
					
					user = new User(
						 	rs.getString("name"),
						 	rs.getInt("age"),
						 	rs.getString("email"),
						 	rs.getLong("phone"),
						 	null);
				}
			}
			
			
		} catch (SQLException e) {
			System.out.println("Login error : " + e.getMessage());
		}
		
		return user;
		
	}
	
	public static boolean emailExists(String email) {
		
		String query = "SELECT email FROM newform WHERE email = ?";
		
		try(Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(query)){
			
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
		
		} catch (SQLException e) {
			System.out.println("Error while registering : " + e.getMessage());
		}
		
		return false;
	}

}
