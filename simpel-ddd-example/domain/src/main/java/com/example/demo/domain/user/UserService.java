package com.example.demo.domain.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

  @Autowired
  private IUserRepository userRepository;

  @Override
  public List<UserDto> getUsers() {
    return this.userRepository.getUsers();
  }

  @Override
  public UserDto getUserById(int id) {
    return this.userRepository.getUserById(id);
  }

  @Override
  public List<UserDto> getUsersByRole(String role) {
    return this.userRepository.getUsersByRole(role);
  }
}
