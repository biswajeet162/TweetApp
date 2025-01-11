package com.tweetapp.controller;


import com.tweetapp.model.TweetDTO;
//import com.tweetapp.service.UserTimelineService;
import com.tweetapp.service.UserTimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeline/user")
public class UserTimelineController {

    @Autowired
    private UserTimelineService userTimelineService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<TweetDTO>> getUserTweets(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(userTimelineService.getUserTweets(userId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<TweetDTO>> searchUserTweets(@RequestParam String username) throws Exception {
        return ResponseEntity.ok(userTimelineService.searchTweetsByUsername(username));
    }
}
