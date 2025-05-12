package com.rtb.core.repository;

import com.rtb.core.entity.user.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {
    Optional<Counter> findByUserId(Long userId);
}
