package com.indrajit.tfz.service.impl;

import com.indrajit.tfz.model.User;
import com.indrajit.tfz.repository.UserRepository;
import com.indrajit.tfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author indrajit
 */

@Service("userService")
public class UserServiceImpl implements UserService{

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        userRepository.save(user);
    }

    @Override
    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            return null;
        }
        return findUserByUserName(authentication.getName());
    }

    @Override
    public void follow(String userName) {
        User currentUser = currentUser();
        if(currentUser == null){
            return;
        }
        User follow_user = findUserByUserName(userName);
        Set<User> followings = currentUser.getFollowings();
        followings.add(follow_user);
        currentUser().setFollowings(followings);
        userRepository.save(currentUser);
    }

    @Override
    public boolean following(User follower, User following) {
        return follower.getFollowings().contains(following);
    }

}