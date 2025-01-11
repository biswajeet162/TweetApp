package com.tweetapp.controller;

import com.tweetapp.model.TweetDTO;
import com.tweetapp.service.HomeTimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/timeline/home")
public class HomeTimelineController {

    @Autowired
    private HomeTimelineService homeTimelineService;

    @GetMapping
    public ResponseEntity<List<TweetDTO>> getAllTweets() {
        return ResponseEntity.ok(homeTimelineService.getAllTweetsWithDetails());
    }
}
