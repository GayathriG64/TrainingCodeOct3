package com.loan.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Loan {
	@Id
	@SequenceGenerator(name ="seq" , initialValue = 11220)
	@GeneratedValue( generator = "seq")
	private Long LoanId;
	private Long accountID;
	private String loanType;
	private Long loanAmount;
	//@Temporal(TemporalType.DATE)
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date appliedDate;
	private Long rateOfInterest;
	private Long duration;
	
	public Long getAccountID() {
		return accountID;
	}
	public Long getLoanId() {
		return LoanId;
	}
	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public Long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Date getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
	public Long getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Long rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Loan(String loanType, Long loanAmount, Long rateOfInterest, Long duration) {
		super();
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.rateOfInterest = rateOfInterest;
		this.duration = duration;
	}
	public Loan() {
		super();
	}
	@Override
	public String toString() {
		return "Loan [accountID=" + accountID + ", loanType=" + loanType + ", loanAmount=" + loanAmount
				+ ", appliedDate=" + appliedDate + ", rateOfInterest=" + rateOfInterest + ", duration=" + duration
				+ "]";
	}
	public Loan(Long loanId, Long accountID, String loanType, Long loanAmount, Date appliedDate, Long rateOfInterest,
			Long duration) {
		super();
		LoanId = loanId;
		this.accountID = accountID;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.appliedDate = appliedDate;
		this.rateOfInterest = rateOfInterest;
		this.duration = duration;
	}
	
}
