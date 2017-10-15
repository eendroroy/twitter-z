package com.indrajit.tfz.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
@Data
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
  @Past(message = "*Date of birth can not be in future")
  private Date dateOfBirth;

  @Column(name = "enabled")
  private int enabled;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(name = "followings",
      joinColumns = {@JoinColumn(name = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "following_user_id")})
  private transient Set<User> followings;

  @ManyToMany(mappedBy = "followings")
  private transient Set<User> followers;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private transient Set<Tweet> tweets;

  public User() {
    followings = new HashSet<>();
    followers = new HashSet<>();
    tweets = new HashSet<>();
  }

  public Date getDateOfBirth() {
    if (dateOfBirth == null) {
      return null;
    } else {
      return new Date(dateOfBirth.getTime());
    }
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = new Date(dateOfBirth.getTime());
  }
}