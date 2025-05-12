package com.rtb.core.enums;

import java.util.stream.Stream;

public enum TemplateEnum {

  VALUE_A("ENUM_VALUE_1"),
  VALUE_B("ENUM_VALUE_2"),
  VALUE_C("ENUM_VALUE_3");

  private final String value;

  TemplateEnum(String value) {
    this.value = value;
  }

  public static TemplateEnum of(String value) {
    return Stream.of(TemplateEnum.values()).filter(v -> v.getValue().equals(value)).findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

  public String getValue() {
    return value;
  }

}
