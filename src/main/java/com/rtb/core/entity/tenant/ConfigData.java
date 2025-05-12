package com.rtb.core.entity.tenant;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ConfigData implements Serializable {
  private String att1;
  private String att2;

  public ConfigData() {
    // Default constructor
  }
}
