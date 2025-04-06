package com.tweetapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class TweetDTO {
    private Long tweetId;

    private Long userId;
    private String userHandle;
    private String userName;

    private String content;

    private Date createdAt;
    private Date updatedAt;

    private String[] imageUrls;
    private String[] videoUrls;

    private List<CommentDTO> comments;
    private List<Long> likes; // User IDs of users who liked the tweet

    private boolean showComments = false;


}
