package fr.chadgpt.chadgpt.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SiteUser {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // Store a hashed version of the user's password

    @Column(nullable = false, unique = true)
    private String username; // Pseudo for the user

    // Add relationships with other entities (e.g., prompts, comments) here
}