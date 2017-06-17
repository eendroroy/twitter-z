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
            2. must be unique
        2. full name (required)
            1. e.g. Hannibal Smith
            2. this will be the name other users will see in the system
        3. username (required)
        4. date of birth (user must be 14+, 16+, 18+ etc.)
        5. gender
        6. profile picture
        7. send welcome email upon registration (optional)
2. Search User:
    1. user can search for other users by e-mail address, nickname
3. User Profile View:
    1. profiles are public
    2. name, profile picture, age, gender - publicly visible
    3. email address is also publicly visible
4. Follow:
    1. user can follow other users
    2. following other users will show their tweets in current user’s home page
5. Tweet:
    1. post a tweet
    2. image attachment option
    3. user can delete his/her tweet
6. Comment:
    1. post a comment under a tweet
    2. image attachment option
    3. owner of the parent tweet can delete a comment
    4. Also the owner of the comment can delete it
7. Favourite List (Optional):
    1. user maintain a favourite list of other users
    2. user will get email notification for any tweet from users in his/her favourite list
8. Black LIst (Optional):
    1. user can maintain a blacklist of other users
    2. blacklisted users can not interact with the current user in any way
    3. blacklisted users can view the profile of current user but will not be able to see any tweet and obviously can not comment under any tweet of current user

## Technological Requirements:

1. Web Framework - (Spring MVC / Spring Boot)
2. ORM - Hibernate
3. Database migration tool - (Liquibase/Flyway)
4. Responsive UI
5. JQuery
6. JUnit (with a minimum of 70% test coverage)
7. Must follow coding conventions
8. Must use Object Oriented Design Principles and Patterns
9. Must use version control for code management. (github/bitbucket)
