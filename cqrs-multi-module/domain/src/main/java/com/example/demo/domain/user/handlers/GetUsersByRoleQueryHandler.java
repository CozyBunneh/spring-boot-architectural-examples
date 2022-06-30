package com.example.demo.domain.user.handlers;

import an.awesome.pipelinr.Command;
import com.example.demo.domain.user.abstractions.UserRepository;
import com.example.demo.domain.user.dtos.UserDto;
import com.example.demo.domain.user.queries.GetUsersByRoleQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUsersByRoleQueryHandler
  implements Command.Handler<GetUsersByRoleQuery, List<UserDto>> {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserDto> handle(GetUsersByRoleQuery query) {
    return this.userRepository.getUsersByRole(query.role());
  }
}
