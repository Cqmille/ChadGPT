package fr.chadgpt.backend;

import fr.chadgpt.backend.model.entity.BlogPost;
import fr.chadgpt.backend.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class ChadGptApplication {

	@Autowired
	private BlogPostService blogPostService;

	public static void main(String[] args) {
		SpringApplication.run(ChadGptApplication.class, args);
	}

	@Bean
	public CommandLineRunner createBlogPosts() {
		return args -> {
			BlogPost blogPost1 = new BlogPost();
			blogPost1.setTitle("Title 1");
			blogPost1.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit...");
			blogPost1.setImageIds(new ArrayList<>());
			blogPostService.saveBlogPost(blogPost1);

			BlogPost blogPost2 = new BlogPost();
			blogPost2.setTitle("Title 2");
			blogPost2.setContent("Vestibulum ullamcorper mauris at ligula...");
			blogPost2.setImageIds(new ArrayList<>());
			blogPostService.saveBlogPost(blogPost2);
		};
	}
}
