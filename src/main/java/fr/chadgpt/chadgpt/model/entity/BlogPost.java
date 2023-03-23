package fr.chadgpt.chadgpt.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.List;


import jakarta.persistence.*;

@Entity
@Data
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
    @CollectionTable(name = "blogpost_image", joinColumns = @JoinColumn(name = "blogpost_id"))
    @Column(name = "image_id")
    private List<String> imageIds;
}
