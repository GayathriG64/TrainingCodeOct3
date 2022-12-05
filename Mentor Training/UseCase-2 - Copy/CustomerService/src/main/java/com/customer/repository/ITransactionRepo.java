package com.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.customer.entity.Transaction;

@Repository
public interface ITransactionRepo extends JpaRepository<Transaction, Long>{
	
	List<Transaction> findByAccountId(Long accountId);
}
