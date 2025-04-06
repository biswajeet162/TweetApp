package com.tweeter_authentication.controller;



import com.tweeter_authentication.model.TokenValidationResponse;
import com.tweeter_authentication.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    public String getProfile() {
        return "✅ Access Granted: User Profile Data";
    }

    @GetMapping("/settings")
    public String getSettings() {
        return "✅ Access Granted: User Settings";
    }
}


