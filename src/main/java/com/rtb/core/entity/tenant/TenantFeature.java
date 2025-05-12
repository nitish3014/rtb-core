package com.rtb.core.entity.tenant;

import com.rtb.core.utils.TenantFeatureId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tenant_features")
@IdClass(TenantFeatureId.class)
public class TenantFeature {

  @Id
  @Column(name = "tenant_id")
  private Long tenantId;

  @Id
  @Column(name = "feature_id")
  private Long featureId;

  @ManyToOne
  @JoinColumn(name = "tenant_id", insertable = false, updatable = false)
  private Tenant tenant;

  @ManyToOne
  @JoinColumn(name = "feature_id", insertable = false, updatable = false)
  private Feature feature;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
}
