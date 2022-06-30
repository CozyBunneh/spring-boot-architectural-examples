package com.example.demo.domain.user.handlers;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import com.example.demo.domain.common.exceptions.NotFoundException;
import com.example.demo.domain.user.abstractions.UserRepository;
import com.example.demo.domain.user.commands.UpdateUserCommand;
import com.example.demo.domain.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserCommandHandler
  implements Command.Handler<UpdateUserCommand, Voidy> {

  private static final String USER_TO_UPDATE_WAS_NOT_FOUND =
    "User to update was not found";

  @Autowired
  private UserRepository userRepository;

  @Override
  public Voidy handle(UpdateUserCommand command) {
    var userToUpdate = userRepository.getUserById(command.user().id());
    if (userToUpdate == null) {
      throw new NotFoundException(USER_TO_UPDATE_WAS_NOT_FOUND);
    }

    // Convert to domain object to apply all domain rules on it.
    var user = User.fromDto(command.user());
    return userRepository.updateUser(user.toDto());
  }
}
