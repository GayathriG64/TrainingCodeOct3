package com.loan.service;

import java.util.List;

import com.loan.entity.Loan;

public interface ILoanService {
	public Loan applyLoan(Loan loan,Long accountID);
	public List<Loan> getAllLoans(Long accountID);
}
