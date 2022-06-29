package com.example.demo.domain.user.queries;

import java.util.List;

import com.example.demo.domain.user.dtos.UserDto;

import an.awesome.pipelinr.Command;

public record GetUsersByRoleQuery(int role) implements Command<List<UserDto>> {
}
