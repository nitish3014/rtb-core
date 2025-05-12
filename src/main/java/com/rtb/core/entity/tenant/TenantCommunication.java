package com.rtb.core.entity.tenant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rtb.core.enums.CommunicationCategory;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "communication", schema = "public")
public class TenantCommunication {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "tenant_id")
  @JsonBackReference
  private Tenant tenant;

  @Enumerated(EnumType.STRING)
  @Column(name = "communication_channel")
  private CommunicationChannel communicationChannel;

  @Column(name = "category")
  @Enumerated(EnumType.STRING)
  private CommunicationCategory category;

  @Column(name = "template_url")
  private String templateUrl;

  private Boolean active;

}
