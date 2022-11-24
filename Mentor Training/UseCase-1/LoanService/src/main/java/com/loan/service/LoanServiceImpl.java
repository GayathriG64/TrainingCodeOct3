package com.loan.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.entity.Loan;
import com.loan.repository.LoanRepository;

@Service
public class LoanServiceImpl implements ILoanService {
	
	@Autowired
	LoanRepository loanRepo;
	@Override
	public Loan applyLoan(Loan loan,Long accountID) {
		Loan savedLoan= new Loan();
		Loan dummy = new Loan();
		Boolean result=false;
		String loanType= loan.getLoanType();
		List<Loan> loanList = loanRepo.findByAccountID(accountID);
		result = loanList.isEmpty();
		if(!result) {
			Iterator<Loan> iter = loanList.listIterator();
			while(iter.hasNext()){
				if(iter.next().getLoanType().equals(loanType)) {
					result=false;
					dummy.setAccountID(0L);
					dummy.setLoanType(loanType);
					return dummy;
				}
			}
		}
		try {
			savedLoan=loanRepo.save(loan);
		}
		catch(Exception e ) {
			System.out.println(e.getMessage());
		}
		return savedLoan;
	}
	@Override
	public List<Loan> getAllLoans(Long accountID) {
		return loanRepo.findByAccountID(accountID);
	}

}
