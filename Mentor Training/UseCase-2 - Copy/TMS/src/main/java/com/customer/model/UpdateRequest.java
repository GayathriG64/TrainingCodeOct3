package com.customer.model;

public class UpdateRequest {	
	
	private String name;
	private String password;
	private String address;
	private String state;
	private String country;
	private String email;
	private Long phoneNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UpdateRequest(String name, String address, String state, String country, String email, Long phoneNo) {
		super();
		this.name = name;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	public UpdateRequest(String password) {
		super();
		this.password = password;
	}
	public UpdateRequest() {
		super();
	}
	
	
}
