package com.indrajit.tfz.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
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
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private long id;

  @Column(name = "email")
  @Email(message = "*Please provide a valid Email")
  @NotEmpty(message = "*Please provide an email")
  private String email;

  @Column(name = "password")
  @Length(min = 5, message = "*Your password must have at least 5 characters")
  @NotEmpty(message = "*Please provide your password")
  private String password;

  @Column(name = "fullname")
  @NotEmpty(message = "*Please provide your full name")
  private String fullName;

  @Column(name = "username")
  private String userName;

  @Column(name = "date_of_birth")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @NotNull(message = "*Please provide your date of birth")
  private Date dateOfBirth;

  @Column(name = "enabled")
  private int enabled;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(name = "followings",
      joinColumns = {@JoinColumn(name = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "following_user_id")})
  private Set<User> followings = new HashSet<>();

  @ManyToMany(mappedBy = "followings")
  private Set<User> followers = new HashSet<>();

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private Set<Tweet> tweets = new HashSet<>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return fullName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public int getEnabled() {
    return enabled;
  }

  public void setEnabled(int enabled) {
    this.enabled = enabled;
  }

  public Set<User> getFollowings() {
    return followings;
  }

  public void setFollowings(Set<User> followings) {
    this.followings = followings;
  }

  public Set<User> getFollowers() {
    return followers;
  }

  public void setFollowers(Set<User> followers) {
    this.followers = followers;
  }

  public Set<Tweet> getTweets() {
    return tweets;
  }

  public void setTweets(Set<Tweet> tweets) {
    this.tweets = tweets;
  }

}