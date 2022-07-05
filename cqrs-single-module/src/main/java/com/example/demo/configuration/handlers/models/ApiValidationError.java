package com.example.demo.configuration.handlers.models;

public record ApiValidationError(
    String object,
    String field,
    Object rejectedValue,
    String message
) implements ApiSubError {}