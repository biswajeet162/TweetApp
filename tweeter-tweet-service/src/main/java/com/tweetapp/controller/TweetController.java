package com.tweetapp.controller;

import com.tweetapp.model.Comment;
import com.tweetapp.model.CommentRequest;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.TweetRequests;
import com.tweetapp.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @GetMapping
    public ResponseEntity<List<Tweet>> getTweets() {
        System.out.println("\n\n\n\n  fetch tweet in controller");
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.getAllTweet());
    }

    @PostMapping("/create")
    public ResponseEntity<Tweet> createTweet(@RequestBody TweetRequests tweetRequest) {
        System.out.println("\n\n\n\n  got tweet in controller {} " + tweetRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(tweetService.createTweet(tweetRequest));
    }

    @PostMapping("/{tweetId}/comment")
    public ResponseEntity<Comment> addComment(@PathVariable Long tweetId, @RequestBody CommentRequest commentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tweetService.addComment(tweetId, commentRequest));
    }

    @PostMapping("/{tweetId}/like")
    public ResponseEntity<Void> likeTweet(@PathVariable Long tweetId, @RequestParam Long userId) {
        tweetService.likeTweet(tweetId, userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
