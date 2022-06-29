package com.example.demo.domain.user.handlers;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import com.example.demo.domain.common.exceptions.NotFoundException;
import com.example.demo.domain.user.abstractions.IUserRepository;
import com.example.demo.domain.user.commands.DeleteUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserCommandHandler
  implements Command.Handler<DeleteUserCommand, Voidy> {

  private static final String USER_TO_REMOVE_COULD_NOT_BE_FOUND =
    "User to remove could not be found";

  @Autowired
  private IUserRepository userRepository;

  @Override
  public Voidy handle(DeleteUserCommand command) {
    var userToDelete = userRepository.getUserById(command.id());
    if (userToDelete == null) {
      throw new NotFoundException(USER_TO_REMOVE_COULD_NOT_BE_FOUND);
    }

    return userRepository.deleteUser(command.id());
  }
}
