package com.indrajit.tfz.service;

import com.indrajit.tfz.model.User;

import java.util.List;

/**
 * @author indrajit
 */

public interface UserService {
  List<User> allUsers();

  User findUserByEmail(String email);

  User findUserByUserName(String userName);

  void saveUser(User user);

  User currentUser();

  boolean isCurrentUser(User user);

  void follow(String userName);

  boolean following(User follower, User following);

}