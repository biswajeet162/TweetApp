package com.tweetapp.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class TweetRequests {

    public Long userId;
    public String content;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}