package com.indrajit.tfz.controller;

import com.indrajit.tfz.model.User;
import com.indrajit.tfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author indrajit
 */

@SuppressWarnings({
    "PMD.TooManyMethods",
    "PMD.AvoidDuplicateLiterals",
    "PMD.ShortVariable",
    "PMD.LongVariable",
    "PMD.ShortClassName",
})
public class BaseController {

  @Autowired
  transient UserService userService;

  @ModelAttribute("currentUser")
  User currentUser() {
    return userService.currentUser();
  }
}
