package fr.chadgpt.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BlogPost {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    private String title;

    @Column(nullable = false)
    private String content;

    // Many-to-one relationship with SiteUser
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private SiteUser author;

    // Use ElementCollection for a simple collection of Strings (imageIds)
    @ElementCollection
    @Column(name = "image_id")
    private List<String> imageIds;

}
