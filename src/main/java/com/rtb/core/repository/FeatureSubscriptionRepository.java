package com.rtb.core.repository;

import com.rtb.core.entity.user.FeatureSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface FeatureSubscriptionRepository extends JpaRepository<FeatureSubscription, Long> {
        @Query("SELECT fs.featureName FROM FeatureSubscription fs WHERE fs.subscriptionId = "
                + ":subscriptionId")
        Set<String> findFeatureNamesBySubscriptionId(@Param("subscriptionId") Long subscriptionId);

    @Modifying
    @Query("DELETE FROM FeatureSubscription fs WHERE fs.subscriptionId = :id")
    void deleteBySubscriptionId(@Param("id") Long id);
}
