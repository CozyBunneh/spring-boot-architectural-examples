package com.example.demo.domain.user;

import java.util.List;

public interface IUserRepository {
  public List<UserDto> getUsers();

  public UserDto getUserById(int id);

  public List<UserDto> getUsersByRole(String role);
}