package com.indrajit.tfz.service.impl;

import com.indrajit.tfz.model.Tweet;
import com.indrajit.tfz.model.User;
import com.indrajit.tfz.repository.TweetRepository;
import com.indrajit.tfz.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

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
@Service("tweetService")
public class TweetServiceImpl implements TweetService {

  @Qualifier("tweetRepository")
  @Autowired
  private transient TweetRepository tweetRepository;

  @Override
  public Set<Tweet> findByUser(User user) {
    return tweetRepository.findByUserId(user.getId());
  }


  @Override
  public void saveTweet(Tweet tweet) {
    tweetRepository.save(tweet);
  }
}
