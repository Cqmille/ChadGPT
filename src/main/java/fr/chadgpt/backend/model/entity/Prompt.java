package fr.chadgpt.backend.model.entity;

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
    private String description;

    @Column(nullable = false)
    private String content;

    @Column
    private String exempleRequest;

    @Column
    private String exempleResponse;

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
                ", exempleRequest='" + exempleRequest + '\'' +
                ", exempleResponse='" + exempleResponse + '\'' +
                ", author=" + author +
                '}';
    }

}

