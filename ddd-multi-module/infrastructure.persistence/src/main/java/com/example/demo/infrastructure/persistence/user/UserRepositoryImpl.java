package com.example.demo.infrastructure.persistence.user;

import com.example.demo.domain.user.abstractions.UserRepository;
import com.example.demo.domain.user.dtos.UserDto;
import com.example.demo.infrastructure.persistence.user.entities.UserEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service("userRepository")
public class UserRepositoryImpl implements UserRepository {

  private List<UserEntity> users = Collections.synchronizedList(
    new ArrayList<>()
  );

  public UserRepositoryImpl() {
    users.add(
      new UserEntity(
        UUID.randomUUID().toString(),
        "TechGeekNext-User1",
        3,
        "user1@test.com"
      )
    );
    users.add(
      new UserEntity(
        UUID.randomUUID().toString(),
        "TechGeekNext-User2",
        2,
        "user2@test.com"
      )
    );
    users.add(
      new UserEntity(
        UUID.randomUUID().toString(),
        "TechGeekNext-User3",
        1,
        "user3@test.com"
      )
    );
    users.add(
      new UserEntity(
        UUID.randomUUID().toString(),
        "TechGeekNext-User4",
        1,
        "user4@test.com"
      )
    );
  }

  @Override
  public void createUser(UserDto user) {
    this.users.add(UserEntity.fromDto(user));
  }

  @Override
  public void deleteUser(String id) {
    users.removeIf(x -> x.id().equals(id));
  }

  @Override
  public List<UserDto> getUsers() {
    return UserEntity.toDtos(users);
  }

  @Override
  public UserDto getUserById(String id) {
    return UserEntity.toDto(
      users
        .stream()
        .filter(x -> x.id().equals(id))
        .collect(Collectors.toList())
        .get(0)
    );
  }

  @Override
  public List<UserDto> getUsersByRole(int role) {
    return UserEntity.toDtos(
      users.stream().filter(x -> x.role() == role).collect(Collectors.toList())
    );
  }

  @Override
  public void updateUser(UserDto user) {
    users
      .stream()
      .filter(x -> x.id().equals(user.id()))
      .findFirst()
      .ifPresent(userToUpdate -> userToUpdate = UserEntity.fromDto(user));
  }
}
