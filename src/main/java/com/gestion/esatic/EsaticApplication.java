package com.gestion.esatic;

import com.gestion.esatic.data.UserRepository;
import com.gestion.esatic.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class EsaticApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsaticApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder) {
		return args -> {
			users.save(new User("patrickcoding710@gmail.com",encoder.encode("password"),"ROLE_USER"));
			users.save(new User("admin5@gmail.com",encoder.encode("password"),"ROLE_USER,ROLE_ADMIN"));

		};
	}*/

}
