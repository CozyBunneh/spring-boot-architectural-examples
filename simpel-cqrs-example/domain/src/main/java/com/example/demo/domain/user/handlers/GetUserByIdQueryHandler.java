package com.example.demo.domain.user.handlers;

import an.awesome.pipelinr.Command;
import com.example.demo.domain.user.abstractions.IUserRepository;
import com.example.demo.domain.user.dtos.UserDto;
import com.example.demo.domain.user.queries.GetUserByIdQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserByIdQueryHandler
  implements Command.Handler<GetUserByIdQuery, UserDto> {

  @Autowired
  private IUserRepository userRepository;

  @Override
  public UserDto handle(GetUserByIdQuery query) {
    return this.userRepository.getUserById(query.id());
  }
}
