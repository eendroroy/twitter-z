package com.indrajit.tfz.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * @author indrajit
 */

@Entity
@Table(name = "tweets")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tweet_id")
    private long id;

    @Column(name = "tweet")
    @NotEmpty(message = "*Please write something")
    private String tweet;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
