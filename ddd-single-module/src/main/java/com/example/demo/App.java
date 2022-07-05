package com.example.demo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
  info = @Info(
    title = "CQRS single module demo API",
    version = "1.0",
    description = "Demo description"
  )
)
@SpringBootApplication(scanBasePackages = { "com.example.demo" })
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
