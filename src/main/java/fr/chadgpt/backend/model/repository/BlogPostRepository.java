package fr.chadgpt.backend.model.repository;

import fr.chadgpt.backend.model.entity.BlogPost;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findTopByOrderByPostDateDesc(Pageable pageable);
}