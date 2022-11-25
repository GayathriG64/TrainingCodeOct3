package com.customer.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@Table
@Entity
public class Customer {
	@Id
	@SequenceGenerator(name ="CustSeq" , initialValue = 1022330000)
	@GeneratedValue( generator = "CustSeq")
	private Long AccountId;
	private String name;
	private String username;
	private String password;
	private String address;
	private String state;
	private String country;
	private String email;
	private String pan;
	private Long phoneNo;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	private String accType;
	
	public Long getAccountId() {
		return AccountId;
	}
	public void setAccountId(Long accountId) {
		AccountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public Customer(Long AccountId, String name, String username, String password, String address, String state,
			String country, String email, String pan, Long phoneNo, Date dob, String accType) {
		super();
		this.AccountId = AccountId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
		this.pan = pan;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.accType = accType;
	}
	public Customer() {
		super();
	}
	public Customer(String name, String username, String password, String address, String state, String country,
			String email, String pan, Long phoneNo, Date dob, String accType) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
		this.pan = pan;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.accType = accType;
	}
	@Override
	public String toString() {
		return "Customer [AccountId=" + AccountId + ", name=" + name + ", username=" + username + ", password="
				+ password + ", address=" + address + ", state=" + state + ", country=" + country + ", email=" + email
				+ ", pan=" + pan + ", phoneNo=" + phoneNo + ", dob=" + dob + ", accType=" + accType + "]";
	}
	
}
