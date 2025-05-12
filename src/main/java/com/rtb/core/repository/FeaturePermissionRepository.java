package com.rtb.core.repository;

import com.rtb.core.entity.tenant.FeaturePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FeaturePermissionRepository extends JpaRepository<FeaturePermission, Long> {

    List<FeaturePermission> findByFeatureIdIn(Set<Long> featureIds);

    List<FeaturePermission> findByPermissionIdIn(List<Long> permissionIds);
}
