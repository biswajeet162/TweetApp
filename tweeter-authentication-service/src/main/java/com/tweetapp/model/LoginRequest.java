package com.tweetapp.model;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank
    private String handle;

    @NotBlank
    private String password;
}
