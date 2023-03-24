package fr.chadgpt.backend.model.repository;

import fr.chadgpt.backend.model.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
