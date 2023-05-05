package com.company.webapi.user;

import com.company.webapi.auth.AuthenticationService;
import com.company.webapi.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserSeed {

    @Bean
	CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(Role.ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstname("Manager")
					.lastname("Manager")
					.email("manager@mail.com")
					.password("password")
					.role(Role.MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}
}
