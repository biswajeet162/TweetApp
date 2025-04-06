package com.tweeter_authentication.controller;

import com.tweeter_authentication.model.AuthRequest;
import com.tweeter_authentication.model.TokenValidationResponse;
import com.tweeter_authentication.model.User;
import com.tweeter_authentication.repository.UserRepository;
import com.tweeter_authentication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public TokenValidationResponse signUp(@RequestBody User user) {
        Optional<User> dbUser = userRepository.findByHandle(user.getHandle());

        if(dbUser.isPresent()){
            throw new RuntimeException("User Already Exist!");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);

        String token = jwtUtil.generateToken(savedUser.getHandle());

        System.out.println("User registered successfully!");

        return new TokenValidationResponse(
                true,
                savedUser.getHandle(),
                savedUser.getName(),
                savedUser.getId(),
                token,
                jwtUtil.extractExpiration(token)
        );
    }


    @PostMapping("/login")
    public TokenValidationResponse login(@RequestBody AuthRequest authRequest) {
        Optional<User> dbUser = userRepository.findByHandle(authRequest.getHandle());

        if(dbUser.isEmpty()){
            throw new RuntimeException("User not found!");
        }


        System.out.println("User found: " + dbUser);

        if (passwordEncoder.matches(authRequest.getPassword(), dbUser.get().getPassword())) {
            String token = jwtUtil.generateToken(authRequest.getHandle());

            return new TokenValidationResponse(
                    true,
                    authRequest.getHandle(),
                    dbUser.get().getName(),
                    dbUser.get().getId(),
                    token,
                    jwtUtil.extractExpiration(token)
            );



        } else {
            throw new RuntimeException("Invalid credentials!");
        }
    }

    @GetMapping("/validate")
    public boolean validateToken(@RequestParam String token) {
        String handle = jwtUtil.extractHandle(token);
        return jwtUtil.validateToken(token, handle);
    }
}
