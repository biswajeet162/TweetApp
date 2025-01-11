package com.tweetapp.repository;

import com.tweetapp.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    @Query(value = "SELECT * FROM Tweet WHERE user_id = :userId", nativeQuery = true)
    List<Tweet> findByUserId(@Param("userId") Long userId);
}
