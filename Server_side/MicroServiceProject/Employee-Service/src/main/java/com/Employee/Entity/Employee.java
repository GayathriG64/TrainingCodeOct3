package com.Employee.Entity;

import java.util.List;

public class Employee {
	private Long empID;
	private String name;
	private String phoneNo;
	List<EmployementRecord> employmentRecord;
	public List<EmployementRecord> getEmploymentRecord() {
		return employmentRecord;
	}
	public void setEmploymentRecord(List<EmployementRecord> employmentRecord) {
		this.employmentRecord = employmentRecord;
	}
	public Long getEmpID() {
		return empID;
	}
	public void setEmpID(Long empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Employee(Long empID, String name, String phoneNo) {
		super();
		this.empID = empID;
		this.name = name;
		this.phoneNo = phoneNo;
		
	}
	
	public Employee(Long empID, String name, String phoneNo, List<EmployementRecord> employmentRecord) {
		super();
		this.empID = empID;
		this.name = name;
		this.phoneNo = phoneNo;
		this.employmentRecord = employmentRecord;
	}
	public Employee(){
		super();
	}
	
}
