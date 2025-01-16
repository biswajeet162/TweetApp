package com.tweetapp.repository;

import com.tweetapp.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query(value = "SELECT * FROM hometimeline_likes WHERE tweet_id = :tweetId", nativeQuery = true)
    List<Like> findByTweetId(Long tweetId);

//    @Query(value = "SELECT COUNT(*) FROM likes WHERE tweet_id = :tweetId", nativeQuery = true)
//    long countByTweetId(@Param("tweetId") Long tweetId);
//
//    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END " +
//            "FROM likes WHERE tweet_id = :tweetId AND user_id = :userId", nativeQuery = true)
//    boolean existsByTweetIdAndUserId(@Param("tweetId") Long tweetId, @Param("userId") Long userId);
}
