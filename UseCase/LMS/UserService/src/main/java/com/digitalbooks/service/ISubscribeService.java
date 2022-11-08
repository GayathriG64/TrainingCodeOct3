package com.digitalbooks.service;

import java.util.List;

import com.digitalbooks.entity.Subscription;

public interface ISubscribeService {
	public List <Subscription> getSubscriptionByReaderId(Long readerId);
	public Subscription saveSubscription(Subscription sub);
	public Subscription getSubscriptionBySubscriptionId(Long subId);
	public void delete(Long subId);
}
