package com.rtb.core.repository;

import com.rtb.core.entity.user.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<Otp, String> {
    Optional<Otp> findByValidationPayload(String validationPayload);
}

