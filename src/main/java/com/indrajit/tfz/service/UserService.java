package com.indrajit.tfz.service;

import com.indrajit.tfz.model.User;

/**
 * @author indrajit
 */

public interface UserService {
  User findUserByEmail(String email);

  User findUserByUserName(String userName);

  void saveUser(User user);

  User currentUser();

  boolean isCurrentUser(User user);

  void follow(String userName);

  boolean following(User follower, User following);

}