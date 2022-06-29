package com.example.demo.api.user.v1;

import com.example.demo.domain.user.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

  private static final String RETURN_TYPE = "application/json";
  private static final String ID = "id";
  private static final String ROLE = "role";
  private static final String USERS_ENDPOINT = "/";
  private static final String USER_ENDPOINT = "/{id}";
  private static final String USER_ROLE_ENDPOINT = "/role/{role}";

  @Autowired
  private IUserService userService;

  @GetMapping(value = USERS_ENDPOINT, produces = RETURN_TYPE)
  public List<UserV1> getUsers() {
    return UserV1.fromDtos(this.userService.getUsers());
  }

  @GetMapping(value = USER_ENDPOINT, produces = RETURN_TYPE)
  public UserV1 getUserById(@PathVariable(value = ID) int id) {
    return UserV1.fromDto(this.userService.getUserById(id));
  }

  @GetMapping(value = USER_ROLE_ENDPOINT, produces = RETURN_TYPE)
  public List<UserV1> getUsersByRole(@PathVariable(value = ROLE) String role) {
    return UserV1.fromDtos(this.userService.getUsersByRole(role));
  }
}
