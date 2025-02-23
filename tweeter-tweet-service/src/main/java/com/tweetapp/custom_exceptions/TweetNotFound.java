package com.tweetapp.custom_exceptions;

public class TweetNotFound extends RuntimeException {
    public TweetNotFound(String message) {
        super(message);
    }
}
