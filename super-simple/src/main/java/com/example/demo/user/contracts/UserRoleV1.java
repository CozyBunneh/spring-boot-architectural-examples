package com.example.demo.user.v1.contracts;

import com.example.demo.user.dtos.UserRoleDto;

public record UserRoleV1(int id, String name) {
    public static UserRoleV1 fromDto(UserRoleDto dto) {
        return new UserRoleV1(dto.id(), dto.name());
    }

    public UserRoleDto toDto() {
        return new UserRoleDto(this.id(), this.name());
    }
}
