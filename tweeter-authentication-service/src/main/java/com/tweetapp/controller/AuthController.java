package com.tweetapp.controller;

import com.tweetapp.model.JwtResponse;
import com.tweetapp.model.LoginRequest;
import com.tweetapp.model.SignUpRequest;
import com.tweetapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Signup Endpoint
    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpRequest request) {
        return authService.signUp(request);
    }

    // Login Endpoint
    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return new JwtResponse(token);
    }

    // Validate Token Endpoint
    @GetMapping("/validate")
    public boolean validateToken(@RequestParam String token) {
        return authService.validateToken(token);
    }

    // Generate New Token
    @GetMapping("/generate")
    public JwtResponse generateToken(@RequestParam String handle) {
        String token = authService.generateToken(handle);
        return new JwtResponse(token);
    }
}
