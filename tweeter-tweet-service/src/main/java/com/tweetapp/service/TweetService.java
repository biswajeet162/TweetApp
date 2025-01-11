package com.tweetapp.service;

import com.tweetapp.model.*;
import com.tweetapp.repository.CommentRepository;
import com.tweetapp.repository.LikeRepository;
import com.tweetapp.repository.TweetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private KafkaTemplate<String, Tweet> tweetKafkaTemplate;
    @Autowired
    private KafkaTemplate<String, Comment> commentKafkaTemplate;
    @Autowired
    private KafkaTemplate<String, Like> likeKafkaTemplate;

    private static final String TWEET_TOPIC = "tweet-topic";
    private static final String COMMENT_TOPIC = "comment-topic";
    private static final String LIKE_TOPIC = "like-topic";

    // Create a new tweet
    public Tweet createTweet(TweetRequests tweetRequest) {
        Tweet tweet = new Tweet();
        tweet.setUserId(tweetRequest.getUserId());
        tweet.setContent(tweetRequest.getContent());
        tweet.setCreatedAt(LocalDateTime.now());
        tweet.setUpdatedAt(LocalDateTime.now());
        Tweet savedTweet = tweetRepository.save(tweet);
        System.out.println("\n\n\n\n Tweet saved in service {} " + savedTweet);

        // Publish to Kafka
        tweetKafkaTemplate.send(TWEET_TOPIC, savedTweet);
        System.out.println("\n\n\n\n\n\n\nTweet broadcasted also in service {} " + savedTweet);

        return savedTweet;
    }

    // Add comment to a tweet
    public Comment addComment(Long tweetId, CommentRequest commentRequest) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new RuntimeException("Tweet not found"));
        Comment comment = new Comment();
        comment.setTweet(tweet);
        comment.setUserId(commentRequest.getUserId());
        comment.setContent(commentRequest.getContent());
        comment.setCreatedAt(LocalDateTime.now());
        comment.setUpdatedAt(LocalDateTime.now());
        Comment savedComment = commentRepository.save(comment);

//         Publish to Kafka
        commentKafkaTemplate.send(COMMENT_TOPIC, savedComment);

        return savedComment;
    }

    // Like a tweet
    public void likeTweet(Long tweetId, Long userId) {
        if (likeRepository.existsByTweetIdAndUserId(tweetId, userId)) {
            throw new RuntimeException("User already liked this tweet");
        }
        Like like = new Like();
        like.setTweet(tweetRepository.findById(tweetId).orElseThrow(() -> new RuntimeException("Tweet not found")));
        like.setUserId(userId);
        like.setCreatedAt(LocalDateTime.now());
        Like savedLike = likeRepository.save(like);

        // Publish to Kafka
        likeKafkaTemplate.send(LIKE_TOPIC, savedLike);
    }

    public List<Tweet> getAllTweet() {
        return tweetRepository.findAll();
    }
}
