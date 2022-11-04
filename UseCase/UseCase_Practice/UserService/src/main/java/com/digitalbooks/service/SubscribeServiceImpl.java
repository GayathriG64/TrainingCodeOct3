package com.digitalbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.entity.Subscription;
import com.digitalbooks.repository.ISubscriptionRepo;

@Service
public class SubscribeServiceImpl implements ISubscribeService {
	@Autowired
	ISubscriptionRepo subscriptionRepo;
	@Override
	public List<Subscription> getSubscriptionByReaderId(Long readerId) {
		List<Subscription> sub =subscriptionRepo.findByReaderId(readerId);
		return sub;
	}
	@Override
	public Subscription saveSubscription(Subscription sub) {
		Subscription savedSub= subscriptionRepo.save(sub);
		return savedSub;
	}
	@Override
	public Subscription getSubscriptionBySubscriptionId(Long subId) {
		Subscription sub = subscriptionRepo.findById(subId).orElse(null);
		return sub;
	}

}
