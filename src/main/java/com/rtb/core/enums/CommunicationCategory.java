package com.rtb.core.enums;

public enum CommunicationCategory {
    WELCOME_EMAIL,
    ACCESS_CREDENTIALS,
    PAYMENT_CONFIRMATION,
    OTP_VERIFICATION,
    PASSWORD_RESET;

    @Override
    public String toString() {
        switch (this) {
            case WELCOME_EMAIL:
                return "Welcome Email";
            case ACCESS_CREDENTIALS:
                return "Access Credentials";
            case PAYMENT_CONFIRMATION:
                return "Payment Confirmation";
            case OTP_VERIFICATION:
                return "OTP Verification";
            case PASSWORD_RESET:
                return "Password Reset";
            default:
                return name();
        }
    }

    public static CommunicationCategory fromString(String category) {
        for (CommunicationCategory communicationCategory : CommunicationCategory.values()) {
            if (communicationCategory.toString().equalsIgnoreCase(category)) {
                return communicationCategory;
            }
        }

        throw new IllegalArgumentException("No constant with category " + category + " found");
    }
}
