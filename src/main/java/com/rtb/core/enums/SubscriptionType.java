package com.rtb.core.enums;

import java.util.stream.Stream;

public enum SubscriptionType {

    FREE("FREE"),
    BASIC("BASIC"),
    PRO("PRO"),;

    private final String value;

    SubscriptionType(String value) {
        this.value = value;
    }


    public static SubscriptionType of(String value) {
        return Stream.of(SubscriptionType.values())
                .filter(v -> v.getValue().equals(value)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getValue() {
        return value;
    }



}
