package com.indrajit.tfz.controller;

import com.indrajit.tfz.model.User;
import com.indrajit.tfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author indrajit
 */

public class BaseController {

    @Autowired
    UserService userService;

    @ModelAttribute("current_user")
    User currentUser(){
        return userService.currentUser();
    }
}
