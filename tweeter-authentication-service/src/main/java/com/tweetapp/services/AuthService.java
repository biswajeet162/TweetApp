package com.tweetapp.services;

import com.tweetapp.config.JwtUtil;
import com.tweetapp.model.LoginRequest;
import com.tweetapp.model.SignUpRequest;
import com.tweetapp.model.User;
import com.tweetapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // Sign Up User
    public String signUp(SignUpRequest request) {
//        if (userRepository.existsByHandle(request.getHandle())) {
//            throw new RuntimeException("Handle is already taken!");
//        }

        User user = new User();
        user.setName(request.getName());
        user.setHandle(request.getHandle());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        return "User registered successfully!";
    }

    // Login User
    public String login(LoginRequest request) {
        Optional<User> user = Optional.of(null);// userRepository.findByHandle(request.getHandle());

        if (user.isPresent() && passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            return jwtUtil.generateToken(user.get().getHandle());
        } else {
            throw new RuntimeException("Invalid username or password!");
        }
    }

    // Validate Token
    public boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }

    // Generate Token
    public String generateToken(String handle) {
        return jwtUtil.generateToken(handle);
    }
}
