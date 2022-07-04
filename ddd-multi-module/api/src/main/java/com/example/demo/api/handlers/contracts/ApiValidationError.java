package com.example.demo.api.handlers.contracts;

public record ApiValidationError(
    String object,
    String field,
    Object rejectedValue,
    String message
) implements ApiSubError {}