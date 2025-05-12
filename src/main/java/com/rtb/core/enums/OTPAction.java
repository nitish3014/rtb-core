package com.rtb.core.enums;

import java.util.stream.Stream;

public enum OTPAction {

    REGISTER("REGISTER"),
    FORGOT_PASSWORD("FORGOT_PASSWORD"),
    TWO_FACTOR_AUTH("TWO_FACTOR_AUTH");

    private final String value;

    OTPAction(String value) {
        this.value = value;
    }

    public static OTPAction of(String value) {
        return Stream.of(OTPAction.values()).filter(v -> v.getValue().equals(value)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getValue() {
        return value;
    }

}
