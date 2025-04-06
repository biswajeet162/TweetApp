package com.tweetapp;

import com.tweetapp.model.User;
import com.tweetapp.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TweeterAuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweeterAuthenticationServiceApplication.class, args);
	}


	@Autowired
	private UserRepository userRepository;

//	@PostConstruct
	public void addInitialUsers() {
		User user1 = new User();
		user1.setName("Alice");

		User user2 = new User();
		user2.setName("Bob");

		User user3 = new User();
		user3.setName("Charlie");

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

		System.out.println("\n\n\n\n\n\n\n\n================================");
		System.out.println("Initial users added to the database\n\n\n\n\n\n\n\n");
	}
}
