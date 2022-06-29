package com.example.demo.api.handlers.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;

public record ApiError(
  HttpStatus status,

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  LocalDateTime timestamp,

  String message,
  String debugMessage,
  List<IApiSubError> subErrors
) {
  public ApiError(HttpStatus status) {
    this(status, LocalDateTime.now(), "", "", new ArrayList<>());
  }

  public ApiError(HttpStatus status, Throwable ex) {
    this(status, LocalDateTime.now(), "Unexpected error", ex.getLocalizedMessage(), new ArrayList<>());
  }

  public ApiError(HttpStatus status, String message, Throwable ex) {
    this(status, LocalDateTime.now(), message, ex.getLocalizedMessage(), new ArrayList<>());
  }
}
