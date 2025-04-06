package com.tweetapp.model;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CommentDTO {
    private Long commentId;
    private Long tweetId;
    private Long userId;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    private String userHandle;

}
