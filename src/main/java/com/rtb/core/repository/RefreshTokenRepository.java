package com.rtb.core.repository;

import com.rtb.core.entity.auth.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    @Query("SELECT rt FROM RefreshToken rt WHERE rt.refreshTokenHash = ?1 AND rt.revoked = false")
    Optional<RefreshToken> findByToken(String token);
}
