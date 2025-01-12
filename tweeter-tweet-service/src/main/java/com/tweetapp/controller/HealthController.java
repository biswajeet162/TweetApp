package com.tweetapp.controller;

import com.tweetapp.model.Tweet;
import com.tweetapp.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthController {

    @Autowired
    private TweetService tweetService;


    @GetMapping( value = "/health")
    public String health(){
        return "Tweet Service HEALTH is Good....";
    }

    @GetMapping
    public List<Tweet> healthsss(){
        List<Tweet> allTweet = tweetService.getAllTweet();
        return allTweet;
    }



}
