package fr.chadgpt.backend;

import fr.chadgpt.backend.model.entity.BlogPost;
import fr.chadgpt.backend.model.entity.SiteUser;
import fr.chadgpt.backend.service.AdminService;
import fr.chadgpt.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class ChadGptApplication {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ChadGptApplication.class, args);
	}

	@Bean
	public CommandLineRunner createBlogPosts() {
		return args -> {
			// Create a new user
			SiteUser camille = new SiteUser();
			camille.setEmail("camille@example.com");
			camille.setPassword("password");
			camille.setUsername("Camille");
			userService.save(camille);

			// Create multiple blog posts associated with the user
			for (int i = 1; i <= 24; i++) {
				BlogPost blogPost = new BlogPost();
				blogPost.setTitle("Title " + i);
				blogPost.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit...");
				blogPost.setImageIds(new ArrayList<>());
				blogPost.setAuthor(camille);
				blogPost.setPostDate(new Date());
				adminService.save(blogPost);
			}
		};
	}
}
