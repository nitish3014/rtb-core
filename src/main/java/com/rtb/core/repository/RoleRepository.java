package com.rtb.core.repository;

import com.rtb.core.entity.user.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Page<Role> findAll(Pageable pageable);

  // Fetch roles based on tenant ID (for users with a tenant ID)
  @Query("""
    SELECT DISTINCT r 
    FROM Role r 
    WHERE (r.tenantId = :tenantId OR (r.tenantId IS NULL AND :tenantId IS NULL))
""")
  Page<Role> findRolesByTenantId(@Param("tenantId") Long tenantId, Pageable pageable);

  @Query("""
    SELECT DISTINCT r 
    FROM Role r 
    WHERE (r.tenantId = :tenantId OR (r.tenantId IS NULL AND :tenantId IS NULL))
""")
  List<Role> findRolesByTenantId(@Param("tenantId") Long tenantId);

  @Query("""
    SELECT DISTINCT r 
    FROM Role r 
    WHERE r.roleName = :endUserRole
""")
  Optional<Role> findByRoleName(String endUserRole);

}
