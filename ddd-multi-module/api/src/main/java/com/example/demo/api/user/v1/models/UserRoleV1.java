package com.example.demo.api.user.v1.models;

import com.example.demo.domain.user.dtos.UserRoleDto;

public record UserRoleV1(int id, String name) {
    public static UserRoleV1 fromDto(UserRoleDto dto) {
        return new UserRoleV1(dto.id(), dto.name());
    }

    public UserRoleDto toDto() {
        return new UserRoleDto(this.id(), this.name());
    }
}
