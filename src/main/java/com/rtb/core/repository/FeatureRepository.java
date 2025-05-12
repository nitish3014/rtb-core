package com.rtb.core.repository;

import com.rtb.core.entity.tenant.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {

  @Query("SELECT DISTINCT f FROM Feature f JOIN TenantFeature tf ON f.id = tf.featureId WHERE tf.tenantId = :tenantId")
  List<Feature> findFeaturesByTenantId(Long tenantId);

  Feature findByFeatureName(String administration);
}

