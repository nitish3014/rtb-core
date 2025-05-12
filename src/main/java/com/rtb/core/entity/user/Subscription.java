package com.rtb.core.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rtb.core.enums.Currency;
import com.rtb.core.enums.SubscriptionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table(name = "subscription")
@Entity
public final class Subscription extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_tier")
    private SubscriptionType subscription;

    @Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;

    @Column(name = "subscription_name")
    private String subscriptionName;

    @Column(name = "subscription_description")
    private String subscriptionDescription;

    @Column(name = "subscription_price")
    private Float subscriptionPrice;

    @Column(name = "duration_in_months")
    private Integer durationInMonths;

    @Column(name = "tenant_id")
    private Long tenantId;

    @Column(name = "product_id")
    private String productId;

    @ManyToMany(mappedBy = "subscription")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

}