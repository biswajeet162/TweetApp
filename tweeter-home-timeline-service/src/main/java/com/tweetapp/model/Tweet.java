package com.tweetapp.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


@Setter
@Getter
@Entity
@Table(name = "hometimeline_tweets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Nullable
public class Tweet {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId;

    private Long userId;
    private String content;

    private Date createdAt;
    private Date updatedAt;

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}