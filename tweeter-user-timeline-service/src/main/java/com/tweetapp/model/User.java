package com.tweetapp.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String handle;
}
