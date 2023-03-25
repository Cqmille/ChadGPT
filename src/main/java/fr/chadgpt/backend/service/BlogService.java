package fr.chadgpt.backend.service;

import fr.chadgpt.backend.model.entity.BlogPost;
import fr.chadgpt.backend.model.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }
}
