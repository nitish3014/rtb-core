package com.rtb.core.enums;

public enum CommunicationChannel {
    EMAIL, SMS, PUSH;

    @Override
    public String toString() {
        switch (this) {
            case EMAIL:
                return "EMAIL";
            case SMS:
                return "SMS";
            case PUSH:
                return "PUSH";
            default:
                throw new IllegalArgumentException("Unknown communication channel: " + this);
        }
    }
}
