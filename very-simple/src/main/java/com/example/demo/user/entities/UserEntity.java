package com.example.demo.user.entities;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.user.dtos.UserDto;
import com.example.demo.user.models.UserRole;

public record UserEntity(String id, String name, int role, String email) {
    public static List<UserDto> toDtos(List<UserEntity> entities) {
        return entities.stream().map(UserEntity::toDto).collect(Collectors.toList());
    }

    public static UserDto toDto(UserEntity entity) {
        var userRoleDto = UserRole.fromId(entity.role()).toDto();
        return new UserDto(entity.id(), entity.name(), userRoleDto, entity.email());
    }

    public static UserEntity fromDto(UserDto dto) {
        return new UserEntity(dto.id(), dto.name(), dto.role().id(), dto.email());
    }
}
