package com.main.medula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.main.medula.repositories")
public class MedulaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedulaApplication.class, args);
	}

}
