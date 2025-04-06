package com.tweetapp.model;


import lombok.Data;
import lombok.Getter;


@Data
public class CommentRequest {

    private Long userId;
    private String userHandle;
    private String content;

}