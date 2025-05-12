package com.rtb.core.repository;

import com.rtb.core.entity.tenant.Tenant;
import com.rtb.core.entity.tenant.TenantCommunicationChannels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ChannelsRepository extends JpaRepository<TenantCommunicationChannels, Long> {

  Set<TenantCommunicationChannels> findAllByTenant(Tenant tenant);

}
