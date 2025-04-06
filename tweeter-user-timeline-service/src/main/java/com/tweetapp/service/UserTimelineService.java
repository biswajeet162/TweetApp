package com.tweetapp.service;

import com.tweetapp.custom_exceptions.TweetNotFound;
import com.tweetapp.model.*;
import com.tweetapp.repository.CommentRepository;
import com.tweetapp.repository.LikeRepository;
import com.tweetapp.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTimelineService {

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeRepository likeRepository;

    /**
     * Fetch tweets for a specific user by user ID.
     *
     * @param userId User ID to fetch tweets for.
     * @return List of TweetDTO objects with details.
     */
    public List<TweetDTO> getUserTweets(Long userId) throws Exception {
        List<Tweet> tweets = tweetRepository.findByUserId(userId);

        System.out.println("=======================================================\n\n\n\n");
        System.out.println(tweets);

        if(tweets == null || tweets.size() == 0){
            throw new TweetNotFound("User Not Found");
        }

        // Map tweets to TweetDTOs with their comments and likes
        return tweets.stream().map(tweet -> {
            List<Comment> comments = commentRepository.findByTweetId(tweet.getTweetId());
            List<Like> likes = likeRepository.findByTweetId(tweet.getTweetId());
            return mapToTweetDTO(tweet, comments, likes);
        }).collect(Collectors.toList());
    }

    /**
     * Search tweets by username.
     *
     * @param username Username to search tweets for.
     * @return List of TweetDTO objects with details.
     */
    public List<TweetDTO> searchTweetsByUsername(String username) throws Exception {

        // make a call to auth serviuce for it
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        User user = new User();

        return getUserTweets(user.getId());

    }


    private TweetDTO mapToTweetDTO(Tweet tweet, List<Comment> comments, List<Like> likes) {
        TweetDTO tweetDTO = new TweetDTO();
        tweetDTO.setTweetId(tweet.getTweetId());
        tweetDTO.setUserId(tweet.getUserId());

        tweetDTO.setUserHandle(tweet.getUserHandle());
        tweetDTO.setUserName(tweet.getUserName());

        tweetDTO.setImageUrls(tweet.getImageUrls());
        tweetDTO.setVideoUrls(tweet.getVideoUrls());

        tweetDTO.setContent(tweet.getContent());
        tweetDTO.setCreatedAt(new Date());
        tweetDTO.setUpdatedAt(tweet.getUpdatedAt());

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
