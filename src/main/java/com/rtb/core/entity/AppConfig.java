package com.rtb.core.entity;

import com.rtb.core.enums.ConfigTypeStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "app_config")
public class AppConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;

    @Column(name = "config_name")
    private String configName;

    @Enumerated(EnumType.STRING)
    @Column(name = "config_type")
    private ConfigTypeStatus configType = ConfigTypeStatus.VALUE;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "config_value", columnDefinition = "TEXT")
    private String configValue;


}
