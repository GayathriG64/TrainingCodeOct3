package com.loan.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.entity.Loan;
import com.loan.service.ILoanService;

@RestController
public class LoanController {
	@Autowired
	ILoanService loanService;
	
	@PostMapping("loan/apply/{accountID}")
	public Loan applyLoan(@RequestBody Loan loan,@PathVariable Long accountID ) {
		loan.setAppliedDate(Date.valueOf(LocalDate.now()));
		loan.setAccountID(accountID);
		return loanService.applyLoan(loan,accountID);
	}
	@GetMapping("loan/AllLoans/{accountID}")
	public List<Loan> getAllLoans(@PathVariable Long accountID){
		List<Loan> listLoans= loanService.getAllLoans(accountID);
		return listLoans;
	}
}
