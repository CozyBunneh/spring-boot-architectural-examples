package com.example.demo.domain.user.dtos;

public record UserDto(String id, String name, UserRoleDto role, String email) {
}
