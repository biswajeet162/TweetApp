package com.tweetapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweetapp.model.Comment;
import com.tweetapp.model.Like;
import com.tweetapp.model.Tweet;
import com.tweetapp.repository.CommentRepository;
import com.tweetapp.repository.LikeRepository;
import com.tweetapp.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserTimeLineKafkaListnerService {

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeRepository likeRepository;


    @KafkaListener(topics = "tweet-topic", groupId = "user-timeline-group")
    public void consumeTweetEvent(String tweet) throws JsonProcessingException {
        //System.out.println("Received Tweet Event: " + tweet);
        // Optional: Cache or preprocess the tweet data if needed

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Tweet tweet1 = objectMapper.readValue(tweet, Tweet.class);
//            System.out.println("Tweet:----------> " + tweet1);
            tweetRepository.save(tweet1);
        }
        catch (Exception e){
            System.out.println("Error Tweet --------------> " + e.getMessage());
        }

    }

    @KafkaListener(topics = "comment-topic", groupId = "user-timeline-group")
    public void consumeCommentEvent(String comment) throws JsonProcessingException {
        //System.out.println("Received Comment Event: " + comment);
        // Optional: Cache or preprocess the comment data if needed

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Comment comment1 = objectMapper.readValue(comment, Comment.class);
//            System.out.println("Comment:----------> " + comment1);
            commentRepository.save(comment1);
        }catch (Exception e){
            System.out.println("Error Comment --------------> " + e.getMessage());
        }
    }

    @KafkaListener(topics = "like-topic", groupId = "user-timeline-group")
    public void consumeLikeEvent(String like) throws JsonProcessingException {
//        System.out.println("Received Like Event for Tweet ID: " + like);
        // Optional: Cache or preprocess the like data if needed

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Like like1 = objectMapper.readValue(like, Like.class);
//            System.out.println("Likes:----------> " + like1);
            likeRepository.save(like1);
        } catch (Exception e) {
            System.out.println("Error Likes --------------> " + e.getMessage());
        }

    }
}
