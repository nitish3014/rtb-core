package com.rtb.core.entity.user;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "feedback_counter")
public class Counter extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_fibonacci_a")
    private Long lastFibonacciA;

    @Column(name = "last_fibonacci_b")
    private Long lastFibonacciB;

    @Column(name = "next_fibonacci_target")
    private Long nextFibonacciTarget;

    @Column(name = "open_count")
    private Long openCount;

    @Column(name = "last_review_date")
    private String lastReviewDate;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "tenant_id")
    private Long tenantId;

    public Counter(Long lastFibonacciA,
                   Long lastFibonacciB,
                   Long nextFibonacciTarget,
                   Long openCount,
                   String lastReviewDate,
                   Long userId,
                   Long tenantId) {

        this.lastFibonacciA = lastFibonacciA;
        this.lastFibonacciB = lastFibonacciB;
        this.nextFibonacciTarget = nextFibonacciTarget;
        this.openCount = openCount;
        this.lastReviewDate = lastReviewDate;
        this.userId = userId;
        this.tenantId = tenantId;
    }

}
