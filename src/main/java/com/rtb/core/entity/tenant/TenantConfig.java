package com.rtb.core.entity.tenant;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtb.core.entity.user.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "tenant_config")
@Getter
@Setter
@Slf4j
public class TenantConfig extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  @Column(nullable = false, columnDefinition = "JSONB")
  @JdbcTypeCode(SqlTypes.JSON)
  private JsonNode configData;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tenant_id", nullable = false)
  private Tenant tenant;

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public ConfigData getConfigData() {
    try {
      return OBJECT_MAPPER.treeToValue(configData, ConfigData.class);
    } catch (Exception e) {
      log.error("Error converting configData to ConfigData object", e);
      return null;
    }
  }

  public void setConfigData(ConfigData configData) {
    try {
      this.configData = OBJECT_MAPPER.valueToTree(configData);
    } catch (Exception e) {
      log.error("Error converting ConfigData object to JsonNode", e);
    }
  }
}
