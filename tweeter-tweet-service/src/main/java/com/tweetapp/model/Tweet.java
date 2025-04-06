package com.tweetapp.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "tweet_tweets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Nullable
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId;

    private Long userId;
    private String userHandle;
    private String userName;
    private String content;


    private String[] imageUrls;
    private String[] videoUrls;


    private Date createdAt;
    private Date updatedAt;

    private boolean showComments = false;

}