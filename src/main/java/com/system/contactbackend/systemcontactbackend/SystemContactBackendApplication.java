package com.system.contactbackend.systemcontactbackend;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.system.contactbackend.systemcontactbackend.model.Contact;
import com.system.contactbackend.systemcontactbackend.repository.ContactRepository;

@SpringBootApplication
public class SystemContactBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemContactBackendApplication.class, args);
	}

	/* 
	@Bean
	CommandLineRunner runner(ContactRepository repository) {
		return args -> { //lamda
			List<Contact> contacts = Arrays.asList(
				new Contact("Doroteo", "doro@gmail.com", LocalDateTime.now()),
				new Contact("Mariana", "mari_2000@gmail.com", LocalDateTime.now()),
				new Contact("Juan", "juanph@gmail.com", LocalDateTime.now()),
				new Contact("Luis", "luisito_a_p@gmail.com", LocalDateTime.now()),
				new Contact("Lucia", "lula@gmail.com", LocalDateTime.now())
			);
			repository.saveAll(contacts);
		};		
	}
	*/
}
