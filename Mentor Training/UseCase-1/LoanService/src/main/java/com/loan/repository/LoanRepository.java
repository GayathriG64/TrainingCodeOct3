package com.loan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.entity.Loan;
@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
	 List <Loan> findByAccountID(Long accountID);
	 
}