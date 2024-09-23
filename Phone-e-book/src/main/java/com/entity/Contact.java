package com.entity;

public class Contact {
	private int userId;
	private int id;
	private String name;
	private String email;
	private String phonno; // If you want to keep the name 'phonno'
	
	public Contact() {
		super();
	}

	public Contact(String name, String email, String phonno, int userId) {
		super();
		this.name = name;
		this.email = email;
		this.phonno = phonno;
		this.userId = userId;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonno() { // Consistent method name
		return phonno;
	}

	public void setPhonno(String phonno) { // Consistent method name
		this.phonno = phonno;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}

