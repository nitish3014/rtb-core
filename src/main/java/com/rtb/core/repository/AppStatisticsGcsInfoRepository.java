package com.rtb.core.repository;

import com.rtb.core.entity.tenant.AppStatisticsGcsInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AppStatisticsGcsInfoRepository extends JpaRepository<AppStatisticsGcsInfo, Long> {
    Optional<AppStatisticsGcsInfo> findByTenantId(Long tenantId);
    Optional<AppStatisticsGcsInfo> findByGcsBucketName(String bucketName);

    @Modifying
    @Transactional
    @Query("DELETE FROM AppStatisticsGcsInfo a WHERE a.tenantId = :tenantId")
    void deleteByTenantId(@Param("tenantId") Long tenantId);
}
