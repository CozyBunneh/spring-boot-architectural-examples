package com.example.demo.domain.user.commands;

import com.example.demo.domain.user.dtos.UserDto;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

public record CreateUserCommand(UserDto user) implements Command<Voidy> {
}
