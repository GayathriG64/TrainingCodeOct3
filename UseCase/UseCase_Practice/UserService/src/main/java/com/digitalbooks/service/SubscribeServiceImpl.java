package com.digitalbooks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.entity.Subscription;
import com.digitalbooks.repository.ISubscriptionRepo;

@Service
public class SubscribeServiceImpl implements ISubscribeService {
	@Autowired
	ISubscriptionRepo subscriptionRepo;
	@Override
	public Subscription getSubscriptionByReaderId(Long readerId) {
		Subscription sub =subscriptionRepo.findById(readerId).orElse(null);
		return sub;
	}
	@Override
	public Subscription saveSubscription(Subscription sub) {
		Subscription savedSub= subscriptionRepo.save(sub);
		return savedSub;
	}

}
