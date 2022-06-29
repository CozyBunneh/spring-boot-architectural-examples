package com.example.demo.api.user.v1;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.domain.user.UserDto;

/**
 * UserV1
 */
public record UserV1(int id, String name, String role, String email) {

    public static List<UserV1> fromDtos(List<UserDto> dtos) {
        return dtos.stream().map(UserV1::fromDto).collect(Collectors.toList());
    }

    public static UserV1 fromDto(UserDto dto) {
        return new UserV1(dto.id(), dto.content(), dto.role(), dto.email());
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
