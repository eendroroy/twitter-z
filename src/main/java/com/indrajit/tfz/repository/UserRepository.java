package com.indrajit.tfz.repository;

import com.indrajit.tfz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author indrajit
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findAll();

  User findByEmail(String email);

  User findByUserName(String userName);

}