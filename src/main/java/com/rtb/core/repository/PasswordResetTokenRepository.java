package com.rtb.core.repository;

import com.rtb.core.entity.user.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<Otp, Long> {
}
