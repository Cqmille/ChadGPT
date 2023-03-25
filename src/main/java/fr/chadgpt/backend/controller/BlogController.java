package fr.chadgpt.backend.controller;

import fr.chadgpt.backend.model.entity.BlogPost;
import fr.chadgpt.backend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String blogMain(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
        int pageSize = 5;
        Page<BlogPost> blogPostsPage = blogService.findPaginated(page, pageSize);
        model.addAttribute("blogPostsPage", blogPostsPage);

        return "blog/index";
    }
}
