package com.tweetapp.repository;


import com.tweetapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByHandle(String handle);
//    boolean existsByHandle(String handle);
}
