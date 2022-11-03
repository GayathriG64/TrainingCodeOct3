package com.digitalbooks.service;

import com.digitalbooks.entity.Subscription;

public interface ISubscribeService {
	public Subscription getSubscriptionByReaderId(Long readerId);
	public Subscription saveSubscription(Subscription sub);
}
