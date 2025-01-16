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
import java.util.Date;
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
    private KafkaTemplate<String, TweetLikes> likeKafkaTemplate;

    private static final String TWEET_TOPIC = "tweet-topic";
    private static final String COMMENT_TOPIC = "comment-topic";
    private static final String LIKE_TOPIC = "like-topic";

    // Create a new tweet
    public Tweet createTweet(TweetRequests tweetRequest) {
        Tweet tweet = new Tweet();
        tweet.setUserId(tweetRequest.getUserId());
        tweet.setContent(tweetRequest.getContent());
        tweet.setCreatedAt(new Date());
        tweet.setUpdatedAt(new Date());
        Tweet savedTweet = tweetRepository.save(tweet);

        // Publish to Kafka
        tweetKafkaTemplate.send(TWEET_TOPIC, savedTweet);
        System.out.println("\n\ntweet saved and broadcasted successfully " +  savedTweet);
        return savedTweet;
    }

    // Add comment to a tweet
    public Comment addComment(Long tweetId, CommentRequest commentRequest) {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new RuntimeException("Tweet not found"));
        Comment comment = new Comment();
        comment.setTweet(tweet);
        comment.setUserId(commentRequest.getUserId());
        comment.setContent(commentRequest.getContent());
        comment.setCreatedAt(new Date());
        comment.setUpdatedAt(new Date());
        Comment savedComment = commentRepository.save(comment);

//         Publish to Kafka
        commentKafkaTemplate.send(COMMENT_TOPIC, savedComment);
        System.out.println("\n\ncomment saved and broadcasted successfully " +  savedComment);
        return savedComment;
    }

    // Like a tweet
    public void likeTweet(Long tweetId, Long userId) {
        if (likeRepository.existsByTweetIdAndUserId(tweetId, userId)) {
            throw new RuntimeException("User already liked this tweet");
        }
        TweetLikes tweetLikes = new TweetLikes();
        tweetLikes.setTweet(tweetRepository.findById(tweetId).orElseThrow(() -> new RuntimeException("Tweet not found")));
        tweetLikes.setUserId(userId);
        tweetLikes.setCreatedAt(new Date());
        TweetLikes savedTweetLikes = likeRepository.save(tweetLikes);

//         Publish to Kafka
        likeKafkaTemplate.send(LIKE_TOPIC, savedTweetLikes);
        System.out.println("\n\nlike saved and broadcasted successfully " + savedTweetLikes);
    }

    public List<Tweet> getAllTweet() {
        return tweetRepository.findAll();
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public List<TweetLikes> getAllLikes() {
        return likeRepository.findAll();
    }
}
