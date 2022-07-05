package com.example.demo.api.user.v1.contracts;

import com.example.demo.domain.user.dtos.UserDto;

public record CreateUserV1(String name, UserRoleV1 role, String email) {
    public UserDto toDto() {
        return new UserDto("0", this.name(), this.role().toDto(), this.email());
    }
}
