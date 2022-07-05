package com.example.demo.domain.user.abstractions;

import an.awesome.pipelinr.Voidy;
import com.example.demo.domain.user.dtos.UserDto;
import java.util.List;

public interface UserRepository {
  public Voidy createUser(UserDto user);

  public Voidy deleteUser(String id);

  public List<UserDto> getUsers();

  public UserDto getUserById(String id);

  public List<UserDto> getUsersByRole(int role);

  public Voidy updateUser(UserDto user);
}
