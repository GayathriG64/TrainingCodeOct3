package com.Employee.Entity;

public class EmployementRecord {
	private long cID;
	private long cName;
	private String cEmail;
	private Integer years;
	private long empID;
	public EmployementRecord(long cID, long cName, String cEmail, Integer years, long empID) {
		super();
		this.cID = cID;
		this.cName = cName;
		this.cEmail = cEmail;
		this.years = years;
		this.empID = empID;
	}
	public long getcID() {
		return cID;
	}
	public void setcID(long cID) {
		this.cID = cID;
	}
	public long getcName() {
		return cName;
	}
	public void setcName(long cName) {
		this.cName = cName;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	public long getEmpID() {
		return empID;
	}
	public void setEmpID(long empID) {
		this.empID = empID;
	}
	
	
	
}
