package com.rtb.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity implements Serializable {

  @Getter
  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Getter
  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

}