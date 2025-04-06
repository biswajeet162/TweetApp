package com.tweetapp.model;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class SignUpRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String handle;

    @NotBlank
    private String password;
}
