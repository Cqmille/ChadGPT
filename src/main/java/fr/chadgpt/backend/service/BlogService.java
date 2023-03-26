package fr.chadgpt.backend.service;

import fr.chadgpt.backend.model.entity.BlogPost;
import fr.chadgpt.backend.model.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public Page<BlogPost> findPaginated(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        return blogPostRepository.findAll(pageable);
    }

    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }
}

