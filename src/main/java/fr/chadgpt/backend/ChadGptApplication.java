package fr.chadgpt.backend;

import fr.chadgpt.backend.model.entity.BlogPost;
import fr.chadgpt.backend.model.entity.SiteUser;
import fr.chadgpt.backend.service.AdminService;
import fr.chadgpt.backend.service.SiteUserService;
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
	private SiteUserService siteUserService;

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
			siteUserService.save(camille);

			// Create a new blog post associated with the user
			BlogPost blogPost1 = new BlogPost();
			blogPost1.setTitle("Title 1");
			blogPost1.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit...");
			blogPost1.setImageIds(new ArrayList<>());
			blogPost1.setAuthor(camille);
			blogPost1.setPostDate(new Date());
			adminService.save(blogPost1);

			// Create another blog post associated with the user
			BlogPost blogPost2 = new BlogPost();
			blogPost2.setTitle("Title 2");
			blogPost2.setContent("Vestibulum ullamcorper mauris at ligula...");
			blogPost2.setImageIds(new ArrayList<>());
			blogPost2.setAuthor(camille);
			blogPost2.setPostDate(new Date());
			adminService.save(blogPost2);
		};
	}
}
