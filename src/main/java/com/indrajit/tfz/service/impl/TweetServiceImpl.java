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

@Service("tweetService")
public class TweetServiceImpl implements TweetService {

    @Qualifier("tweetRepository")
    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public Set<Tweet> findByUser(User user) {
        return tweetRepository.findByUser(user);
    }

    @Override
    public void saveTweet(Tweet tweet) {
        tweetRepository.save(tweet);
    }

    @Override
    public void deleteTweet(Tweet tweet) {
        tweetRepository.delete(tweet);
    }

    @Override
    public void deleteTweetByUser(User user) {
        tweetRepository.deleteByUser(user);
    }
}
