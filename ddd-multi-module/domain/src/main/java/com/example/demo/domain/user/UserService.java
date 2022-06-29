package com.example.demo.domain.user;

import com.example.demo.domain.common.exceptions.NotFoundException;
import com.example.demo.domain.user.abstractions.IUserRepository;
import com.example.demo.domain.user.abstractions.IUserService;
import com.example.demo.domain.user.dtos.UserDto;
import com.example.demo.domain.user.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

  private static final String USER_TO_REMOVE_COULD_NOT_BE_FOUND =
    "User to remove could not be found";
  private static final String USER_TO_UPDATE_WAS_NOT_FOUND =
    "User to update was not found";

  @Autowired
  private IUserRepository userRepository;

  @Override
  public void createUser(UserDto dto) {
    // Convert to domain model to apply all domain rules on it.
    var user = User.newFromDto(dto);
    userRepository.createUser(user.toDto());
  }

  @Override
  public void deleteUser(String id) {
    var userToDelete = userRepository.getUserById(id);
    if (userToDelete == null) {
      throw new NotFoundException(USER_TO_REMOVE_COULD_NOT_BE_FOUND);
    }

    userRepository.deleteUser(id);
  }

  @Override
  public List<UserDto> getUsers() {
    return userRepository.getUsers();
  }

  @Override
  public UserDto getUserById(String id) {
    return userRepository.getUserById(id);
  }

  @Override
  public List<UserDto> getUsersByRole(int role) {
    return userRepository.getUsersByRole(role);
  }

  @Override
  public void updateUser(UserDto dto) {
    var userToUpdate = userRepository.getUserById(dto.id());
    if (userToUpdate == null) {
      throw new NotFoundException(USER_TO_UPDATE_WAS_NOT_FOUND);
    }

    // Convert to domain object to apply all domain rules on it.
    var user = User.fromDto(dto);
    userRepository.updateUser(user.toDto());
  }
}
