package com.indrajit.tfz.controller;

import com.indrajit.tfz.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author indrajit
 */

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/login");
        return modelAndView;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/user/login?logout";
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user/registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("user", user);
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            modelAndView.setViewName("user/registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.setViewName("user/login");
        }
        return modelAndView;
    }

    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ModelAndView profile(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userService.currentUser());
        modelAndView.setViewName("user/profile");
        return modelAndView;
    }

    @RequestMapping(value="/profile/{userName}", method = RequestMethod.GET)
    public ModelAndView profile(@PathVariable(name = "userName") String userName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userService.findUserByUserName(userName));
        modelAndView.setViewName("user/profile");
        return modelAndView;
    }

    @RequestMapping(value="/follow/{userName}", method = RequestMethod.GET)
    public ModelAndView follow(@PathVariable(name = "userName") String userName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userService.currentUser());
        userService.follow(userName);
        modelAndView.addObject("successMessage", "Now following " + userName);
        modelAndView.setViewName("user/profile");
        return modelAndView;
    }

}
