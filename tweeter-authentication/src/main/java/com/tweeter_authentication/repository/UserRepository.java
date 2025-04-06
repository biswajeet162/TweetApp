package com.tweeter_authentication.repository;

import com.tweeter_authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByHandle(String handle);
}
