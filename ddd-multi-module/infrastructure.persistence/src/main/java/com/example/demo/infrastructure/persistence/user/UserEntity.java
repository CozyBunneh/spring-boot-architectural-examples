package com.example.demo.infrastructure.persistence.user;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.domain.user.UserDto;

public record UserEntity(int id, String content, String role, String email) {
    public static List<UserDto> toDtos(List<UserEntity> entities) {
        return entities.stream().map(UserEntity::toDto).collect(Collectors.toList());
    }

    public static UserDto toDto(UserEntity entity) {
        return new UserDto(entity.id, entity.content, entity.role, entity.email);
    }
}
