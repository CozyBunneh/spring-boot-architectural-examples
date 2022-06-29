package com.example.demo.api.handlers.models;

public record ApiValidationError(
    String object,
    String field,
    Object rejectedValue,
    String message
) implements IApiSubError {}