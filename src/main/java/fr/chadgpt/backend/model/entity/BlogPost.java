package fr.chadgpt.backend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 10)
    private String content;

    // Many-to-one relationship with SiteUser
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private SiteUser author;

    // Use ElementCollection for a simple collection of Strings (imageIds)
    @ElementCollection
    @Column(name = "image_id")
    private List<String> imageIds;

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + (author != null ? author.getUsername() : "null") +
                ", imageIds=" + imageIds +
                '}';
    }
}
