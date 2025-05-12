package com.rtb.core.repository;

import com.rtb.core.entity.tenant.Tenant;
import com.rtb.core.entity.tenant.TenantCommunication;
import com.rtb.core.enums.CommunicationCategory;
import com.rtb.core.enums.CommunicationChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface TenantCommunicationRepository extends JpaRepository<TenantCommunication, Long> {

  Set<TenantCommunication> findAllByTenant(Tenant tenant);

  Optional<TenantCommunication> findByTenantAndId(Tenant tenant, Long id);

  @Query("SELECT tc FROM TenantCommunication tc "
          + "WHERE tc.tenant = :tenant AND tc.category = :category "
          + "AND tc.communicationChannel = :channel")
  Optional<TenantCommunication> existsByTenantAndCategoryAndChannel(
          Tenant tenant, CommunicationCategory category, CommunicationChannel channel);
}
