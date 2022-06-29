package com.example.demo.infrastructure.persistence.user;

import com.example.demo.domain.user.IUserRepository;
import com.example.demo.domain.user.UserDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service("userRepository")
public class UserRepository implements IUserRepository {

  private List<UserEntity> users = new ArrayList<>();

  public UserRepository() {
    users.add(
      new UserEntity(1, "TechGeekNext-User1", "ADMIN", "user1@test.com")
    );
    users.add(
      new UserEntity(2, "TechGeekNext-User2", "SUPERVISOR", "user2@test.com")
    );
    users.add(
      new UserEntity(3, "TechGeekNext-User3", "USER", "user3@test.com")
    );
    users.add(
      new UserEntity(4, "TechGeekNext-User4", "USER", "user4@test.com")
    );
  }

  @Override
  public List<UserEntity> getUsers() {
    return UserEntity.toDtos(users);
  }

  @Override
  public UserEntity getUserById(int id) {
    return UserEntity.toDto(
      users
        .stream()
        .filter(x -> x.id() == (id))
        .collect(Collectors.toList())
        .get(0)
    );
  }

  @Override
  public List<UserEntity> getUsersByRole(String role) {
    return UserEntity.toDtos(
      users
        .stream()
        .filter(x -> x.role().equalsIgnoreCase(role))
        .collect(Collectors.toList())
    );
  }
}
