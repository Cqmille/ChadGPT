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
    private String title; // Renamed from 'intitule' to 'title' for better readability

    @Column(nullable = false) // Added 'nullable = false' to make it not null
    private String content; // Renamed from 'contenu' to 'content' for better readability

    // Many-to-one relationship with SiteUser, assuming 'SiteUser' is the correct user entity class
    @ManyToOne // Many-to-one relationship (Yes, many-to-one is correct here)
    @JoinColumn(name = "author_id") // Specify the foreign key column name
    private SiteUser author;

    // Use ElementCollection for a simple collection of Strings (imageIds)
    @ElementCollection
    @CollectionTable(name = "blogpost_image", joinColumns = @JoinColumn(name = "blogpost_id"))
    @Column(name = "image_id")
    private List<String> imageIds; // This implementation assumes you're storing image IDs as strings, and images are fetched from a storage service like FTP, S3, or similar
}
