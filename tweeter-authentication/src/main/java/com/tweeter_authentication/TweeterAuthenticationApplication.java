package com.tweeter_authentication;

import com.tweeter_authentication.model.User;
import com.tweeter_authentication.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TweeterAuthenticationApplication {

	private final UserRepository userRepository;

    public TweeterAuthenticationApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(TweeterAuthenticationApplication.class, args);
	}


	@PostConstruct
	public void initUsers() {
		List<User> users = List.of(
				new User("Biswa1", "biswa1", "biswa123"),
				new User("Biswa2", "biswa2", "biswa123"),
				new User("Biswa3", "biswa3", "biswa123"),
				new User("Biswa4", "biswa4", "biswa123")
		);

		// Save only if users with these handles do not exist
		for (User user : users) {
			if (userRepository.findByHandle(user.getHandle()).isEmpty()) {
				userRepository.save(user);
				System.out.println("✅ Added user: " + user.getName());
			} else {
				System.out.println("⚠️ User with handle '" + user.getHandle() + "' already exists.");
			}
		}
	}
}
