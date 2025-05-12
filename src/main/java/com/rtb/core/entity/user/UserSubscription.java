package com.rtb.core.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user_subscriptions")
@NoArgsConstructor
public class UserSubscription {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "order_status", nullable = false)
    private String orderStatus;

    public UserSubscription(User user, Subscription subscription,
                            LocalDateTime startDate, LocalDateTime endDate) {
        this.user = user;
        this.subscription = subscription;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}