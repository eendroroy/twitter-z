package com.indrajit.tfz.service;

import com.indrajit.tfz.model.Tweet;
import com.indrajit.tfz.model.User;

import java.util.Set;

/**
 * @author indrajit
 */

public interface TweetService {
    Set<Tweet> findByUser(User user);
    void saveTweet(Tweet tweet);
}
