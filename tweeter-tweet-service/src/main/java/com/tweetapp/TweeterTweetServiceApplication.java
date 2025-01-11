package com.tweetapp;

import com.tweetapp.model.Tweet;
import com.tweetapp.repository.TweetRepository;
import com.tweetapp.service.TweetService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TweeterTweetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweeterTweetServiceApplication.class, args);
	}


	@Autowired
	TweetRepository tweetRepository;

	@PostConstruct
	public void fun(){

		System.out.println("\n\n\n\n\ntweet app inserted data-----------\n\n\n\n\n");

		tweetRepository.save(new Tweet());
	}


}
