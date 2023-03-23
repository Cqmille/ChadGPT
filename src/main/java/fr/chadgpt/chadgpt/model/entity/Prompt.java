package fr.chadgpt.chadgpt.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prompt {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String text;

    // Many-to-one relationship with SiteUser
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private SiteUser user;
}

