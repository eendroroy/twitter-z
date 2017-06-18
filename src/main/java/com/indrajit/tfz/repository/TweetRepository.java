package com.indrajit.tfz.repository;

import com.indrajit.tfz.model.Tweet;
import com.indrajit.tfz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

/**
 * @author indrajit
 */

@Repository("tweetRepository")
@Transactional
public interface TweetRepository extends JpaRepository {
    Set<Tweet> findByUser(User user);

    @Query("delete from tweets t where t.tweet_id = ?1")
    void delete(Tweet tweet);

    @Query("delete from tweets t where t.user_id = ?1")
    void deleteByUser(User user);
}
