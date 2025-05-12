package com.rtb.core.entity.tenant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rtb.core.enums.CommunicationChannel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "communication_channel")
public class TenantCommunicationChannels {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "tenant_id")
  @JsonIgnore
  private Tenant tenant;

  @Enumerated(EnumType.STRING)
  private CommunicationChannel communicationChannel;

  @Column(name = "active")
  private Boolean active = false;

}
