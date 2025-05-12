package com.rtb.core.repository;

import com.rtb.core.entity.user.Subscription;
import com.rtb.core.enums.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Optional<Subscription> findBySubscription(SubscriptionType subscription);
}
