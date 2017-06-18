package com.indrajit.tfz.helper;

import com.domingosuarez.boot.autoconfigure.jade4j.JadeHelper;
import com.indrajit.tfz.model.User;
import com.indrajit.tfz.service.UserService;
import com.indrajit.tfz.service.impl.UserServiceImpl;

/**
 * @author indrajit
 */

@JadeHelper("UH")
public class UserHelper {
    public boolean following(User follower, User following){
        UserService userService = new UserServiceImpl();
        return userService.following(follower, following);
    }

    public boolean isCurrentUser(User user){
        UserService userService = new UserServiceImpl();
        return userService.isCurrentUser(user);
    }
}
