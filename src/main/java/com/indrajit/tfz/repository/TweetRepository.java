package com.indrajit.tfz.repository;

import com.indrajit.tfz.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author indrajit
 */

@Repository("tweetRepository")
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    Set<Tweet> findByUserId(long userId);
}
