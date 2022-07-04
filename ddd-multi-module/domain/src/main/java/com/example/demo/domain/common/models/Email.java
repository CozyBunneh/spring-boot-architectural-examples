package com.example.demo.domain.common.models;

public record Email(String email) {
    private static final String AT = "@";
    private static final String NOT_A_CORRECT_EMAIL_ADDRESS = "Not a correct email address";

    public Email {
        // FIXME: This validation of an email address isn't good enough
        if (!email.contains(AT) || !email.contains(".")) {
            throw new IllegalArgumentException(NOT_A_CORRECT_EMAIL_ADDRESS);
        }
    }
}
