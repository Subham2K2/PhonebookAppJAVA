//package com.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//
//import com.entity.Contact;
//
//public class ContactDAO {
//	private Connection conn;
//	
//	public ContactDAO(Connection conn) {
//		super();
//		this.conn = conn;
//	}
//	
//	public boolean saveContact(Contact c) {
//		boolean f=false;
//		
//		try {
//			String sql = "insert into contact(name, email, phonno, userid) value (?,?,?,?)";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, c.getName());
//			ps.setString(2, c.getEmail());
//			ps.setString(3, c.getPhonno());
//			ps.setInt(4, c.getUserId());
//			
//			
//			int i = ps.executeUpdate();
//			if (i==1) {
//				f=true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return f;
//	}
//}





package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Contact;

public class ContactDAO {
    private Connection conn;
    
    public ContactDAO(Connection conn) {
        this.conn = conn;
    }
    
    public boolean saveContact(Contact c) {
        boolean f = false;
        
        try {
            String sql = "INSERT INTO contact(name, email, phonno, userid) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPhonno());
            ps.setInt(4, c.getUserId());
            
            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            
            if (rowsAffected == 1) {
                f = true;
            }
        } catch (SQLException e) {
            System.out.println("Error while inserting contact: " + e.getMessage());
            e.printStackTrace();
        }
        
        return f;
    }
    
    public List<Contact> getAllContact(int uId){
    	List<Contact>list=new ArrayList<Contact>();
    	Contact contact=null;
    	try {
    		String sql = "select * from contact where userid=?";
    		PreparedStatement pt = conn.prepareStatement(sql);
    		pt.setInt(1, uId);
    		
    		ResultSet rs = pt.executeQuery();
    		
    		while(rs.next()) {
    			Contact c=new Contact();
    			c.setId(rs.getInt(1));
    			c.setName(rs.getString(2));
    			c.setEmail(rs.getString(3));
    			c.setPhonno(rs.getString(4));
    			list.add(c);
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return list;
    }
    
    
    public Contact getContactByID(int cid) {
    	Contact c=new Contact();
    	try {
			PreparedStatement ps = conn.prepareStatement("select * from contact where id=?");
			ps.setInt(cid, cid);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhonno(rs.getString(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return c;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

