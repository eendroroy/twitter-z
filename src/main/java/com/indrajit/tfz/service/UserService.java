package com.indrajit.tfz.service;

import com.indrajit.tfz.model.User;

/**
 * @author indrajit
 */

public interface UserService {
    public User findUserByEmail(String email);
    public User findUserByUserName(String userName);
    public void saveUser(User user);
    public User currentUser();
}