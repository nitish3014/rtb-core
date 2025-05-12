package com.rtb.core.repository;


import com.rtb.core.entity.user.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByPermissionName(String permission);
}
