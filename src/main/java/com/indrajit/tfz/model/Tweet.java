package com.indrajit.tfz.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

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
@Entity
@Table(name = "tweets")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tweet_id")
    private long id;

    @Column(name = "tweetBody")
    @NotEmpty(message = "*Please write something")
    private String tweetBody;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user = null;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTweetBody() {
        return tweetBody;
    }

    public void setTweetBody(String tweetBody) {
        this.tweetBody = tweetBody;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
