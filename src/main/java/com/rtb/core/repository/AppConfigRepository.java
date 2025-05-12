package com.rtb.core.repository;

import com.rtb.core.entity.AppConfig;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppConfigRepository extends JpaRepository<AppConfig, Long> {
    Optional<AppConfig> findByTenantIdAndConfigName(Long tenantId, String configName);
    Optional<AppConfig> findByTenantId(Long tenantId);

    @Modifying
    @Transactional
    @Query("DELETE FROM AppConfig a WHERE a.tenantId = :tenantId")
    void deleteByTenantId(@Param("tenantId") Long tenantId);


}
