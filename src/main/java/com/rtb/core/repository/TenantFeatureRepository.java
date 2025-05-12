package com.rtb.core.repository;

import com.rtb.core.entity.tenant.TenantFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantFeatureRepository extends JpaRepository<TenantFeature, Long> {
  void deleteByTenantIdAndFeatureId(Long tenantId, Long featureId);
  boolean existsByTenantIdAndFeatureId(Long tenantId, Long featureId);
  List<TenantFeature> findByTenantId(Long tenantId);
}
