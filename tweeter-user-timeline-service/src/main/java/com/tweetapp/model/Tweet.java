package com.tweetapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


@Setter
@Getter
@Entity
@Table(name = "usertimeline_tweets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Nullable
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tweet {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
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