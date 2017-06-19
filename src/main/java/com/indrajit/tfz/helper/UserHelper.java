package com.indrajit.tfz.helper;

import com.domingosuarez.boot.autoconfigure.jade4j.JadeHelper;
import com.indrajit.tfz.model.User;
import com.indrajit.tfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author indrajit
 */

@JadeHelper("UH")
public class UserHelper {

    @Autowired
    private transient UserService userService;

    public boolean following(User follower, User following) {
        return userService.following(follower, following);
    }

    public boolean isCurrentUser(User user) {
        return userService.isCurrentUser(user);
    }
}
