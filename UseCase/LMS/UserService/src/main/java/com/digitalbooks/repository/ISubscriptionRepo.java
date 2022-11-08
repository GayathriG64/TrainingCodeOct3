package com.digitalbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbooks.entity.Subscription;

@Repository
public interface ISubscriptionRepo extends JpaRepository<Subscription, Long> {
	List <Subscription> findByReaderId(Long readerId);
	Subscription findBySubscriptionID(Long subscriptionID);
	
}
