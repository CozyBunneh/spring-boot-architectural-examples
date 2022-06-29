package com.example.demo.domain.common.entities;

import java.util.UUID;

public record GlobalId(String id) {
  private static final String INVALID_USER_ID =
    "User ID has to be a valid UUID";

  public GlobalId {
    try {
      UUID.fromString(id);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(INVALID_USER_ID);
    }
  }
}
