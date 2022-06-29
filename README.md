# Multi module project setup guide

https://www.baeldung.com/maven-multi-module

## Create parent project

mvn archetype:generate -DgroupId=com.example -DartifactId=<project-name>
mvn archetype:generate -DgroupId=com.postnord -DartifactId=<project-name>

## Create sub projects

Do these steps inside of the parent project folder.

### Api

mvn archetype:generate -DgroupId=com.example.api -DartifactId=api
mvn archetype:generate -DgroupId=com.postnord.api -DartifactId=api

### Domain

mvn archetype:generate -DgroupId=com.example.domain -DartifactId=domain
mvn archetype:generate -DgroupId=com.postnord.domain -DartifactId=domain

### Infrastructure Persistence

mvn archetype:generate -DgroupId=com.example.infrastructure.persistence -DartifactId=infrastructure.persistence
mvn archetype:generate -DgroupId=com.postnord.infrastructure.persistence -DartifactId=infrastructure.persistence

## Build it!

`mvn package`

## Run

`mvn spring-boot:run`

## Swagger

http://localhost:8080/v3/api-docs/
http://localhost:8080/swagger-ui/index.html

## PipelinR

https://github.com/sizovs/PipelinR
