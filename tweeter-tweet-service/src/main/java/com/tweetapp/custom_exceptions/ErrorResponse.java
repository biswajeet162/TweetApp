package com.tweetapp.custom_exceptions;


import lombok.Data;

import java.util.Date;

@Data
public class ErrorResponse {
    private String message;
    private int status;
    private Date timestamp;

    public ErrorResponse(String message, int status, Date timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters and Setters
}
