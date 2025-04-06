package com.tweetapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "tweet_comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Nullable
@JsonIgnoreProperties( ignoreUnknown = true)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private Long userId;
    private String userHandle;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY) // Assuming many comments per tweet
    @JoinColumn(name = "tweet_id", nullable = false)
//    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Tweet tweet;

    private Date createdAt;
    private Date updatedAt;

}