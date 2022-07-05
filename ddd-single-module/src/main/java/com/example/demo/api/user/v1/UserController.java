package com.example.demo.api.user.v1;

import com.example.demo.api.user.v1.contracts.CreateUserV1;
import com.example.demo.api.user.v1.contracts.UserV1;
import com.example.demo.domain.user.abstractions.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  private UserService userService;

  @PutMapping(value = USER_ENDPOINT, consumes = JSON)
  public void createUser(@RequestBody CreateUserV1 user) {
    userService.createUser(user.toDto());
  }

  @DeleteMapping(value = USER_ENDPOINT, consumes = JSON)
  public void deleteUser(@PathVariable(value = ID) String id) {
    userService.deleteUser(id);
  }

  @GetMapping(value = USERS_ENDPOINT, produces = JSON)
  public List<UserV1> getUsers() {
    return UserV1.fromDtos(userService.getUsers());
  }

  @GetMapping(value = USER_ENDPOINT, produces = JSON)
  public UserV1 getUserById(@PathVariable(value = ID) String id) {
    return UserV1.fromDto(userService.getUserById(id));
  }

  @GetMapping(value = USER_ROLE_ENDPOINT, produces = JSON)
  public List<UserV1> getUsersByRole(@PathVariable(value = ROLE) int role) {
    return UserV1.fromDtos(userService.getUsersByRole(role));
  }

  @PostMapping(value = USER_ENDPOINT, consumes = JSON)
  public void updateUser(@RequestBody UserV1 user) {
    userService.updateUser(user.toDto());
  }
}
