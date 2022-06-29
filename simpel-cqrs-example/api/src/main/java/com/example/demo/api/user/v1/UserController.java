package com.example.demo.api.user.v1;

import an.awesome.pipelinr.Pipeline;
import com.example.demo.api.user.v1.models.CreateUserV1;
import com.example.demo.api.user.v1.models.UserV1;
import com.example.demo.domain.user.commands.CreateUserCommand;
import com.example.demo.domain.user.commands.DeleteUserCommand;
import com.example.demo.domain.user.commands.UpdateUserCommand;
import com.example.demo.domain.user.queries.GetAllUsersQuery;
import com.example.demo.domain.user.queries.GetUserByIdQuery;
import com.example.demo.domain.user.queries.GetUsersByRoleQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

  private static final String JSON = "application/json";
  private static final String ID = "id";
  private static final String ROLE = "role";
  private static final String USERS_ENDPOINT = "/";
  private static final String USER_ENDPOINT = "/{id}";
  private static final String USER_ROLE_ENDPOINT = "/role/{role}";

  @Autowired
  Pipeline pipeline;

  @PutMapping(value = USERS_ENDPOINT, consumes = JSON)
  public void createUser(@RequestBody CreateUserV1 user) {
    new CreateUserCommand(user.toDto()).execute(pipeline);
  }

  @DeleteMapping(value = USER_ENDPOINT, consumes = JSON)
  public void deleteUser(@PathVariable(value = ID) String id) {
    new DeleteUserCommand(id).execute(pipeline);
  }

  @GetMapping(value = USERS_ENDPOINT, produces = JSON)
  public List<UserV1> getUsers() {
    return UserV1.fromDtos(new GetAllUsersQuery().execute(pipeline));
  }

  @GetMapping(value = USER_ENDPOINT, produces = JSON)
  public UserV1 getUserById(@PathVariable(value = ID) String id) {
    return UserV1.fromDto(new GetUserByIdQuery(id).execute(pipeline));
  }

  @GetMapping(value = USER_ROLE_ENDPOINT, produces = JSON)
  public List<UserV1> getUsersByRole(@PathVariable(value = ROLE) int role) {
    return UserV1.fromDtos(new GetUsersByRoleQuery(role).execute(pipeline));
  }

  @PostMapping(value = USER_ENDPOINT, consumes = JSON)
  public void updateUser(@RequestBody UserV1 user) {
    new UpdateUserCommand(user.toDto()).execute(pipeline);
  }
}
