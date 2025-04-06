package com.tweetapp.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweetapp.model.*;
import com.tweetapp.repository.CommentRepository;
import com.tweetapp.repository.LikeRepository;
import com.tweetapp.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeTimelineService {

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeRepository likeRepository;

    /**
     * Fetch all tweets with their comments and likes.
     *
     * @return List of TweetDTO objects containing tweet details, comments, and likes.
     */
//    public List<TweetDTO> getAllTweetsWithDetails() {
//        List<Tweet> tweets = tweetRepository.findAll();
//
//        // Map tweets to TweetDTO with their comments and likes
//        return tweets.stream().map(tweet -> {
//            List<Comment> comments = commentRepository.findByTweetId(tweet.getTweetId());
//            List<Like> likes = likeRepository.findByTweetId(tweet.getTweetId());
//            return mapToTweetDTO(tweet, comments, likes);
//        }).collect(Collectors.toList());
//    }

    public List<TweetDTO> getAllTweetsWithDetails() {
        List<Tweet> tweets = tweetRepository.findAll();

        return tweets.stream()
                .map(tweet -> {
                    List<Comment> comments = commentRepository.findByTweetId(tweet.getTweetId());
                    List<Like> likes = likeRepository.findByTweetId(tweet.getTweetId());
                    return mapToTweetDTO(tweet, comments, likes);
                })
                .sorted(Comparator.comparing(TweetDTO::getCreatedAt))
                .collect(Collectors.toList());
    }

    private TweetDTO mapToTweetDTO(Tweet tweet, List<Comment> comments, List<Like> likes) {
        TweetDTO tweetDTO = new TweetDTO();
        tweetDTO.setTweetId(tweet.getTweetId());
        tweetDTO.setUserId(tweet.getUserId());
        tweetDTO.setUserHandle(tweet.getUserHandle());
        tweetDTO.setUserName(tweet.getUserName());


        tweetDTO.setContent(tweet.getContent());
        tweetDTO.setCreatedAt(tweet.getCreatedAt());
        tweetDTO.setUpdatedAt(tweet.getUpdatedAt());

        tweetDTO.setImageUrls(tweet.getImageUrls());
        tweetDTO.setVideoUrls(tweet.getVideoUrls());

        tweetDTO.setComments(comments.stream().map(this::mapToCommentDTO).collect(Collectors.toList()));
        tweetDTO.setLikes(likes.stream().map(Like::getUserId).collect(Collectors.toList()));

        return tweetDTO;
    }

    private CommentDTO mapToCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(comment.getCommentId());
        commentDTO.setTweetId(comment.getTweet().getTweetId());
        commentDTO.setUserId(comment.getUserId());
        commentDTO.setUserHandle(comment.getUserHandle());
        commentDTO.setContent(comment.getContent());
        commentDTO.setCreatedAt(comment.getCreatedAt());
        commentDTO.setUpdatedAt(comment.getUpdatedAt());
        return commentDTO;
    }
}
