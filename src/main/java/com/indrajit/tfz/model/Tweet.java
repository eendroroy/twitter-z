package com.indrajit.tfz.model;

import lombok.Data;
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
@Data
public class Tweet {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "tweet_id")
  private long id;

  @Column(name = "tweet_body")
  @NotEmpty(message = "*Please write something")
  private String tweetBody;

  @ManyToOne()
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
