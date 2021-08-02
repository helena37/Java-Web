package bg.hristoskova.userservice;

import bg.hristoskova.userservice.domain.Role;
import bg.hristoskova.userservice.domain.User;
import bg.hristoskova.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	 CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Elena Hristoskova", "helena", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Borislav Hristoskov", "bobi", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Dobromira Dobreva", "dobi", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Boncho Dobrev", "boni", "1234", new ArrayList<>()));

			userService.addRoleToUser("helena", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("helena", "ROLE_ADMIN");
			userService.addRoleToUser("helena", "ROLE_USER");
			userService.addRoleToUser("bobi", "ROLE_MANAGER");
			userService.addRoleToUser("boni", "ROLE_ADMIN");
			userService.addRoleToUser("dobi", "ROLE_USER");
			userService.addRoleToUser("dobi", "ROLE_MANAGER");
		};
	}

}
