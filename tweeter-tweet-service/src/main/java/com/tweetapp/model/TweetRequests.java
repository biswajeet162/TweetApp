package com.tweetapp.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class TweetRequests {

    public Long userId;
    public String content;
    public String userHandle;
    private String userName;

    private String[] imageUrls;
    private String[] videoUrls;

}