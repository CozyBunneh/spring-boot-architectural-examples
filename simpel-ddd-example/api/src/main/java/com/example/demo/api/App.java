package com.example.demo.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
  info = @Info(
    title = "DDD Demo API",
    version = "1.0",
    description = "demo description"
  )
)
@SpringBootApplication(scanBasePackages = { "com.example.demo" })
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
