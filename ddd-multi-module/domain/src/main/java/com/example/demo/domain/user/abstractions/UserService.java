package com.example.demo.domain.user.abstractions;

import com.example.demo.domain.user.dtos.UserDto;
import java.util.List;

public interface UserService {
  public void createUser(UserDto user);

  public void deleteUser(String id);

  public List<UserDto> getUsers();

  public UserDto getUserById(String id);

  public List<UserDto> getUsersByRole(int role);

  public void updateUser(UserDto user);
}
