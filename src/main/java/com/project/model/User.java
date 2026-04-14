package com.project.model;

public class User {
	
	private String name;
	private int age;
	private String email;
	private Long phone;
	private String password;
	
	public User() {
		
	}
	
	public User(String name, int age, String email, Long phone, String password) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
