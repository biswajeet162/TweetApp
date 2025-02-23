package com.tweetapp;

import com.tweetapp.model.Comment;
import com.tweetapp.model.CommentRequest;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.TweetRequests;
import com.tweetapp.repository.LikeRepository;
import com.tweetapp.repository.TweetRepository;
import com.tweetapp.service.TweetService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class TweeterTweetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweeterTweetServiceApplication.class, args);
	}


	@Autowired
	private KafkaTemplate<String, Tweet> tweetKafkaTemplate;
	@Autowired
	private TweetService tweetService;
	@Autowired
	TweetRepository tweetRepository;

	@Autowired
	private LikeRepository likeRepository;

	private static final String TWEET_TOPIC = "tweet-topic";
	private static final String COMMENT_TOPIC = "comment-topic";
	private static final String LIKE_TOPIC = "like-topic";

	//@PostConstruct
	public void fun(){

		for(long userId=1; userId<10; userId++){
			TweetRequests tweetRequests = new TweetRequests();
			tweetRequests.setUserId(userId);
			tweetRequests.setContent("Helloooo - " + userId);
			Tweet savedTweet = tweetService.createTweet(tweetRequests);


			CommentRequest commentRequest =  new CommentRequest();
			commentRequest.setUserId(userId);
			commentRequest.setContent("Comment Hello  " + userId);
			Comment savedComment = tweetService.addComment(savedTweet.getTweetId(), commentRequest);


			tweetService.likeTweet(savedTweet.getTweetId(), userId);
		}



		System.out.println("\n\n\n\n\n inserted and boradcasted all data--------\n\n\n\n\n");
		long l = likeRepository.countByTweetId(1L);
		System.out.println("\n\n\n\n\n inserted and boradcasted all data-------- "+ l);

	}


}
