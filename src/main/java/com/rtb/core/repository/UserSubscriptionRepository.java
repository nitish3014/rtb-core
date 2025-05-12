package com.rtb.core.repository;

import com.rtb.core.entity.user.UserSubscription;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {

    @Query("SELECT us FROM UserSubscription us WHERE us.user.id = :userId ORDER BY us.startDate "
            + "DESC")
    List<UserSubscription> findByUserIdOrderByStartDateDesc(@Param("userId") Long userId,
                                                            Pageable pageable);

    default Optional<UserSubscription> findLatestByUserId(Long userId) {
        List<UserSubscription> subscriptions = findByUserIdOrderByStartDateDesc(userId,
                PageRequest.of(0, 1));
        return subscriptions.isEmpty() ? Optional.empty() : Optional.of(subscriptions.get(0));
    }
}
