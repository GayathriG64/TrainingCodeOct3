package com.EmployementRecord.entity;

public class EmployementRecord {
	private Long cID;
	private String cName;
	private String cEmail;
	private Integer years;
	private Long empID;
	public EmployementRecord(Long cID, String cName, String cEmail, Integer years, Long empID) {
		super();
		this.cID = cID;
		this.cName = cName;
		this.cEmail = cEmail;
		this.years = years;
		this.empID = empID;
	}
	public Long getcID() {
		return cID;
	}
	public void setcID(Long cID) {
		this.cID = cID;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
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
	public Long getEmpID() {
		return empID;
	}
	public void setEmpID(Long empID) {
		this.empID = empID;
	}
	
	
	
}
