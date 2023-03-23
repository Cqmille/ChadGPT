package fr.chadgpt.chadgpt.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {

    @ToString.Include
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @ToString.Include
    @Column(nullable = false, unique = true)
    private String email;

    @ToString.Include
    @Column(nullable = false)
    private String password; // Store a hashed version of the user's password

    @ToString.Include
    @Column(nullable = false, unique = true)
    private String username; // Pseudo for the user

    // Add relationships with other entities (e.g., prompts, comments) here
}