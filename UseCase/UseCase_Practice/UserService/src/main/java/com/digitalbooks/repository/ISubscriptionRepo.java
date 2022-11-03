package com.digitalbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbooks.entity.Subscription;

@Repository
public interface ISubscriptionRepo extends JpaRepository<Subscription, Long> {

}
