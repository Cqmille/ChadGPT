package fr.chadgpt.backend.service;

import fr.chadgpt.backend.model.entity.BlogPost;
import fr.chadgpt.backend.model.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public Optional<BlogPost> getBlogPostById(Long id) {
        return blogPostRepository.findById(id);
    }

    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }

    public void save(BlogPost blogPost) {
        blogPostRepository.save(blogPost);
    }
}