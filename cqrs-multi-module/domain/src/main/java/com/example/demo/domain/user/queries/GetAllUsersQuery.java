package com.example.demo.domain.user.queries;

import an.awesome.pipelinr.Command;

import java.util.List;

import com.example.demo.domain.user.dtos.UserDto;

public record GetAllUsersQuery() implements Command<List<UserDto>> {
}
