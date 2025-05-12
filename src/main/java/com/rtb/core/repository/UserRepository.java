package com.rtb.core.repository;

import com.rtb.core.entity.user.Role;
import com.rtb.core.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Long countByTenantId(Long tenantId);
    @Query("SELECT u FROM User u WHERE u.userDetails.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    Page<User> findByTenantId(Long tenantId, Pageable pageable);  // Pagination already added

    @Query("SELECT u FROM User u JOIN u.role r "
            + "WHERE u.tenantId = :tenantId AND r.roleName != 'end user' ORDER BY u.id ASC")
    Page<User> findByTenantIdExcludingEndUser(@Param("tenantId") Long tenantId, Pageable pageable);


    @Query("SELECT u FROM User u JOIN u.role r "
            + "WHERE u.tenantId = :tenantId AND r.roleName = :roleName ORDER BY u.id ASC")
    Page<User> findByTenantIdAndRoleName(@Param("tenantId") Long tenantId,
                                         @Param("roleName") String roleName, Pageable pageable);

    @Query("SELECT COUNT(u) > 0 FROM User u "
            + "WHERE u.userDetails.username = :username")
    boolean existsByUsername(String username);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.userDetails.email = :email")
    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u "
            + "WHERE u.tenantId = :tenantId AND u.userDetails.username = :username")
    User findByTenantIdAndUserName(@Param("tenantId") Long tenantId,
                                   @Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.tenantId = :tenantId AND u.id = :userId")
    Optional<User> findByTenantIdAndUserId(@Param("tenantId") Long tenantId,
                                           @Param("userId") Long userId);

    Page<User> findByStatus(String status, Pageable pageable);  // Pagination added

    @Query("SELECT u FROM User u JOIN u.role r WHERE r.roleName = :role")
    Page<User> findByRole(@Param("role") String role, Pageable pageable);  // Pagination added

    @Query("SELECT u FROM User u WHERE u.tenantId = :tenantId AND u.status = :status")
    Page<User> findByTenantIdAndStatus(@Param("tenantId") Long tenantId,
                                       @Param("status") String status, Pageable pageable);  // Pagination added

    @Query("SELECT u FROM User u JOIN u.role r WHERE u.tenantId = :tenantId AND r.roleName = :role")
    Page<User> findByTenantIdAndRole(@Param("tenantId") Long tenantId,
                                     @Param("role") String role, Pageable pageable);  // Pagination added

    @Query("SELECT u FROM User u JOIN u.role r WHERE u.status = :status AND r.roleName = :role")
    Page<User> findByStatusAndRole(@Param("status") String status,
                                   @Param("role") String role, Pageable pageable);  // Pagination added

    @Query("SELECT u FROM User u JOIN u.role r "
            + "WHERE u.tenantId = :tenantId AND u.status = :status AND r.roleName = :role")
    Page<User> findByTenantIdAndStatusAndRole(@Param("tenantId") Long tenantId,
                                              @Param("status") String status, @Param("role") String role,
                                              Pageable pageable);  // Pagination added

    @Query("SELECT u.userDetails.profilePicURL FROM User u WHERE u.id = :userId")
    Optional<String> findProfilePicURLById(@Param("userId") Long userId);

    @Query("SELECT u FROM User u WHERE u.tenantId IS NULL")
    Page<User> findPlatformUser(Pageable pageable);

    Optional<User> findByAppleId(String appleId);

    @Query("SELECT u FROM User u WHERE u.userDetails.email = :email AND u.role = :role")
    Optional<User> findByEmailAndRole(@Param("email") String email, @Param("role") Role role);
}