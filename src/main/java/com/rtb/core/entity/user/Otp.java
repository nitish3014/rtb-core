package com.rtb.core.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "otp")
@Entity
public class Otp extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // Encrypted data about the otp, usually user related information
    @Column(name = "validation_payload", columnDefinition = "TEXT")
    private String validationPayload;

    @Column(name = "value")
    private String value;

    @Column(name = "used")
    private boolean used = false;

    @Column(name = "resends")
    private int resends;

    public Otp(String validationPayload, String value) {
        this.validationPayload = validationPayload;
        this.value = value;
    }

}