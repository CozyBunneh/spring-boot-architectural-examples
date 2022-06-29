package com.example.demo.domain.user.handlers;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import com.example.demo.domain.user.abstractions.IUserRepository;
import com.example.demo.domain.user.commands.CreateUserCommand;
import com.example.demo.domain.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler
  implements Command.Handler<CreateUserCommand, Voidy> {

  @Autowired
  private IUserRepository userRepository;

  @Override
  public Voidy handle(CreateUserCommand command) {
    // Convert to domain object to apply all domain rules on it.
    var user = User.newFromDto(command.user());
    return userRepository.createUser(user.toDto());
  }
}
