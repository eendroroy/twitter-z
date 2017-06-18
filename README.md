# Twitter For Zombies

## Description:

Basically it is a clone of twitter ([https://twitter.com/](https://twitter.com/)) with fewer and simpler features.

## User Interface:

User interface can be simple but should **contain as much information as possible without making it messy** ( put some brains to show your creativity and imagination power ).

## Feature List:

1. User Registration:
    1. To use "Twitter For Zombies" one must register as user.
        1. email address (required)
            1. e.g. zombie@example.com
            1. must be unique
        1. full name (required)
            1. e.g. Hannibal Smith
            1. this will be the name other users will see in the system
        1. username (required)
        1. date of birth (user must be 14+, 16+, 18+ etc.)
        1. gender
        1. profile picture
        1. send welcome email upon registration (optional)
1. Search User:
    1. user can search for other users by e-mail address, nickname
1. User Profile View:
    1. profiles are public
    1. name, profile picture, age, gender - publicly visible
    1. email address is also publicly visible
1. Follow:
    1. user can follow other users
    1. following other users will show their tweets in current user’s home page
1. Tweet:
    1. post a tweet
    1. image attachment option
    1. user can delete his/her tweet
1. Comment:
    1. post a comment under a tweet
    1. image attachment option
    1. owner of the parent tweet can delete a comment
    1. Also the owner of the comment can delete it
1. Favourite List (Optional):
    1. user maintain a favourite list of other users
    1. user will get email notification for any tweet from users in his/her favourite list
1. Black LIst (Optional):
    1. user can maintain a blacklist of other users
    1. blacklisted users can not interact with the current user in any way
    1. blacklisted users can view the profile of current user but will not be able to see any tweet and obviously can not comment under any tweet of current user

## Technological Requirements:

1. Language - (Java/Groovy/Kotlin)
1. Web Framework - (Spring MVC / Spring Boot)
1. ORM - Hibernate
1. Database migration tool - (Liquibase/Flyway)
1. Responsive UI
1. JQuery
1. JUnit (with a minimum of 70% test coverage)
1. Must follow coding conventions
1. Must use Object Oriented Design Principles and Patterns
1. Must use version control for code management. (github/bitbucket)
