package com.indrajit.tfz.controller;

import com.indrajit.tfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author indrajit
 */

public class BaseController {

    @Autowired
    UserService userService;

    void setCurrentUser(ModelAndView modelAndView){
        modelAndView.addObject("current_user", userService.currentUser());
    }
}
