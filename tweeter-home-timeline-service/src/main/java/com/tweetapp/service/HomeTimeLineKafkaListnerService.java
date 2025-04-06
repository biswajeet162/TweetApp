package com.tweetapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweetapp.custom_exceptions.TweetNotFound;
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
public class HomeTimeLineKafkaListnerService {

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeRepository likeRepository;


    @KafkaListener(topics = "tweet-topic", groupId = "usertimeline-group")
    public void consumeTweetEvent(String tweet) throws JsonProcessingException {
//        System.out.println("\n\n\nReceived Tweet Event: " + tweet);
        // Optional: Cache or preprocess the tweet data if needed

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Tweet tweet1 = objectMapper.readValue(tweet, Tweet.class);
            System.out.println("\n\n\n\n  Deserialized Tweet: " + tweet1);
            tweetRepository.save(tweet1);
 }
        catch (Exception e){
            System.out.println("Error Tweet --------------> " + e.getMessage());
        }


    }

    @KafkaListener(topics = "comment-topic", groupId = "home-timeline-group")
    public void consumeCommentEvent(String comment) throws JsonProcessingException {
//        System.out.println("Received Comment Event: " + comment);
        // Optional: Cache or preprocess the comment data if needed

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Comment comment1 = objectMapper.readValue(comment, Comment.class);
//            System.out.println("\n\n\n\n\n\nDeserialized Comment: " + comment1);
            commentRepository.save(comment1);
        } catch (Exception e) {
            System.out.println("\n\n\n\n\n\nError Comment --------------> " + e.getMessage());
            throw new TweetNotFound("Commented Tweet Not Found" + e.getMessage());
        }

    }

    @KafkaListener(topics = "like-topic", groupId = "home-timeline-group")
    public void consumeLikeEvent(String like) throws JsonProcessingException {
//        System.out.println("Received Like Event for Tweet ID: " + like);
        // Optional: Cache or preprocess the like data if needed

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Like like1 = objectMapper.readValue(like, Like.class);
//            System.out.println("\n\n\n\n\n\nDeserialized Comment: " + like1);
            likeRepository.save(like1);
        }catch (Exception e){
            System.out.println("\n\n\n\n\n\nError Like --------------> " + e.getMessage());
            throw new TweetNotFound("Liked Tweet Not Found" + e.getMessage());
        }

    }
}
