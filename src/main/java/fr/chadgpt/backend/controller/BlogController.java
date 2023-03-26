package fr.chadgpt.backend.controller;

import fr.chadgpt.backend.model.entity.BlogPost;
import fr.chadgpt.backend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listPosts(Model model,
                            @RequestParam("page") Optional<Integer> page) {

        int currentPage = page.orElse(1);
        int pageSize = 10;

        Page<BlogPost> postPage = blogService.findPaginated(currentPage, pageSize);

        model.addAttribute("postPage", postPage);

        int totalPages = postPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "blog/index";
    }

}
