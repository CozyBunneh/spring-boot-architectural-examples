package com.example.demo.domain.user.queries;

import com.example.demo.domain.user.dtos.UserDto;

import an.awesome.pipelinr.Command;

public record GetUserByIdQuery(String id) implements Command<UserDto> {
}
