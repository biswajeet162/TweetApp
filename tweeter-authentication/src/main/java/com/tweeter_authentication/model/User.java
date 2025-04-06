package com.tweeter_authentication.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String handle;

    @Column(nullable = false)
    private String password;

    public User(String name, String handle, String password) {
        this.name = name;
        this.handle = handle;
        this.password = password;
    }
}
