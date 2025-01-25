package com.tweetapp.controller;

import com.tweetapp.model.User;
import com.tweetapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Autowired
//    private KafkaTemplate<String, String> tweetKafkaTemplate;
//
//    @Autowired
//    private KafkaTemplate<String, User> userKafkaTemplate;


    @GetMapping( value = "/hii")
    public String getAllUserssdds() {
        return "hiiiiiii";
    }


    @GetMapping( value = "/hi")
    public String getAllUsersss() {
        return "hellloooo worlddddfdsfffsvsdfsdfdfdsfsdfsdfsdfsfsdfdsffds hjhgjgghghkghkjhkjhkjhjk";
    }




    @GetMapping( value = "/kafka")
    public String getAllUserssskkk() {
//        tweetKafkaTemplate.send("topic", new User().toString());

        return "send messahe-----------------------";
    }


    @GetMapping( value = "/kafka-user")
    public String getAllUserssskkUser() {
        User user = new User();
        user.setId(34L);
        user.setName("HElloooooOOOOOOOO");
//        userKafkaTemplate.send("topic", user);


        System.out.println("message send-----------------------" + user.toString());

        return "message send-----------------------" + user.toString();
    }



    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
//        tweetKafkaTemplate.send("topic", savedUser.toString());

        return savedUser;

    }
}
