package fr.chadgpt.backend.controller;

import fr.chadgpt.backend.model.entity.BlogPost;
import fr.chadgpt.backend.service.AdminService;
import fr.chadgpt.backend.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BlogService blogService;

    @GetMapping
    public String adminDashboard(Model model) {
        List<BlogPost> blogPosts = blogService.findAll();
        model.addAttribute("blogPosts", blogPosts);
        return "admin/admin"; // Updated return path
    }

    @GetMapping("/post")
    public String showCreateBlogPostForm(Model model) {
        model.addAttribute("blogPost", new BlogPost());
        return "admin/post"; // This should be the path to your blog post creation form
    }

    @PostMapping("/post")
    public String createBlogPost(@Valid @ModelAttribute BlogPost blogPost, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/post";
        }

        adminService.save(blogPost);
        System.out.println("BlogPost Added");
        return "redirect:/admin"; // Redirect to the blog post list or any other page
    }
}

