package com.example.demo.user.v1.contracts;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.user.dtos.UserDto;

/**
 * UserV1
 */
public record UserV1(String id, String name, UserRoleV1 role, String email) {

    public static List<UserV1> fromDtos(List<UserDto> dtos) {
        return dtos.stream().map(UserV1::fromDto).collect(Collectors.toList());
    }

    public static UserV1 fromDto(UserDto dto) {
        return new UserV1(dto.id(), dto.name(), UserRoleV1.fromDto(dto.role()), dto.email());
    }

    public UserDto toDto() {
        return new UserDto(this.id(), this.name(), this.role().toDto(), this.email());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
