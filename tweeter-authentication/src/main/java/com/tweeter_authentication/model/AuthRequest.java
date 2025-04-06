package com.tweeter_authentication.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String handle;
    private String password;
}
