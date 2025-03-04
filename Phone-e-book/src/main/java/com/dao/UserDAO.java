package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAO {
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	public boolean userRegister(User u)
	{
		boolean f = false;
		
		try {
			String sql = "insert into user(name,email, password) values (?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			
			int i = ps.executeUpdate();
			
			if(i==1)f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public User loginUser(String e, String p)
	{
		User user = null;
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e);
			ps.setString(2, p);
			
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
	            user.setId(rs.getInt("id"));  
	            user.setName(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password")); 
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return user;
	}
}


