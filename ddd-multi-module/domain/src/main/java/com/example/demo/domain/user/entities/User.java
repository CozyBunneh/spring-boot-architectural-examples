package com.example.demo.domain.user.entities;

import java.util.UUID;

import com.example.demo.domain.common.entities.Email;
import com.example.demo.domain.common.entities.GlobalId;
import com.example.demo.domain.user.dtos.UserDto;

public record User(GlobalId id, String name, UserRole role, Email email) {

    public static User newFromDto(UserDto dto) {
        return new User(new GlobalId(UUID.randomUUID().toString()), dto.name(), UserRole.fromDto(dto.role()), new Email(dto.email()));
    }

    public UserDto toDto() {
        return new UserDto(this.id().id(), this.name(), this.role.toDto(), this.email().email());
    }

    public static User fromDto(UserDto dto) {
        return new User(new GlobalId(dto.id()), dto.name(), UserRole.fromDto(dto.role()), new Email(dto.email()));
    }
}
