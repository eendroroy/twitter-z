package com.indrajit.tfz.controller;

import com.indrajit.tfz.model.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
@Controller
@RequestMapping("/tweet")
public class TweetController extends BaseController {

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ModelAndView createNewUser(@Valid Tweet tweet, BindingResult bindingResult) {
    ModelAndView modelAndView = new ModelAndView();
    if (bindingResult.hasErrors()) {
      modelAndView.addObject("tweet", tweet);
      modelAndView.addObject("errors", bindingResult.getAllErrors());
      modelAndView.setViewName("home/index");
    } else {
      tweetService.saveTweet(tweet);
      modelAndView.addObject("successMessage", "Tweet created successfully");
      modelAndView.setViewName("home/index");
    }
    return modelAndView;
  }

}
