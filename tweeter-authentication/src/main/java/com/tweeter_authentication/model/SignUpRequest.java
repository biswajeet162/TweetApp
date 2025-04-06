package com.tweeter_authentication.model;

import lombok.Data;

@Data
public class SignUpRequest {
    private String name;
    private String handle;
    private String password;
}
