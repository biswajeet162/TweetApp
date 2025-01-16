package com.tweetapp.repository;

import com.tweetapp.model.TweetLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<TweetLikes, Long> {

    @Query("SELECT COUNT(l) FROM TweetLikes l WHERE l.tweet.id = :tweetId")
    long countByTweetId(@Param("tweetId") Long tweetId);

    @Query("SELECT CASE WHEN COUNT(tl) > 0 THEN true ELSE false END FROM TweetLikes tl WHERE tl.tweet.id = :tweetId AND tl.userId = :userId")
    boolean existsByTweetIdAndUserId(@Param("tweetId") Long tweetId, @Param("userId") Long userId);

}

