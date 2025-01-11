package com.tweetapp.services;

import com.tweetapp.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListerService {


    @KafkaListener(topics = "topic", groupId = "timeline-group")
    public void consumeTweetEvent(String tweet) {
        System.out.println("\n\n\n\n\n\nNew Tweet recieveddddd:-------------------------------------------------- " + tweet);
        // Add logic to process the tweet (e.g., update timeline database or cache)
    }

    @KafkaListener(topics = "tweet-topic", groupId = "timeline-group")
    public void consumeTweetEventffff(String tweet) {
        System.out.println("\n\n\n\n\n\nNew Tweet recieveddddd:-------------------tweet-topic------------------------------- " + tweet);
        // Add logic to process the tweet (e.g., update timeline database or cache)
    }
}
