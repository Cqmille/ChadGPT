package fr.chadgpt.backend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(min = 3, max = 255)
    private String description;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 10)
    private String content;

    @Column
    @Size(max = 255)
    private String exampleRequest;

    @Column
    @Size(max = 255)
    private String exampleResponse;

    // Many-to-one relationship with SiteUser
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private SiteUser author;

    @Override
    public String toString() {
        return "Prompt{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", exampleRequest='" + exampleRequest + '\'' +
                ", exampleResponse='" + exampleResponse + '\'' +
                ", author=" + (author != null ? author.getUsername() : "null") +
                '}';
    }
}

