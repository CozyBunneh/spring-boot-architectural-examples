package com.example.demo.user.models;

import com.example.demo.user.dtos.UserRoleDto;

/**
 * Enumeration class instead of enum value.
 */
public record UserRole(int id, String name) {
    public static final UserRole UNKNOWN = new UserRole(1, "Unknown");
    public static final UserRole USER = new UserRole(1, "User");
    public static final UserRole SUPERVISOR = new UserRole(2, "Supervisor");
    public static final UserRole ADMIN = new UserRole(3, "Admin");

    public static UserRole fromId(int id) {
        if (id == UserRole.USER.id()) {
            return UserRole.USER;
        }
        else if (id == UserRole.SUPERVISOR.id()) {
            return UserRole.SUPERVISOR;
        }
        else if (id == UserRole.ADMIN.id()) {
            return UserRole.ADMIN;
        }
        else {
            return UserRole.UNKNOWN;
        }
    }

    public static UserRole fromName(String name) {
        if (name.equals(UserRole.USER.name())) {
            return UserRole.USER;
        }
        else if (name.equals(UserRole.SUPERVISOR.name())) {
            return UserRole.SUPERVISOR;
        }
        else if (name.equals(UserRole.ADMIN.name())) {
            return UserRole.ADMIN;
        }
        else {
            return UserRole.UNKNOWN;
        }
    }

    public static UserRole fromDto(UserRoleDto dto) {
        return UserRole.fromId(dto.id());
    }

    public UserRoleDto toDto() {
        return new UserRoleDto(this.id(), this.name());
    }
}
