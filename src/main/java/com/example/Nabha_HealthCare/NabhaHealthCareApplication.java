package com.example.Nabha_HealthCare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.Nabha_HealthCare.Entity")
@EnableJpaRepositories(basePackages = "com.example.Nabha_HealthCare.Repositories")
@ComponentScan(basePackages = "com.example.Nabha_HealthCare")
public class NabhaHealthCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(NabhaHealthCareApplication.class, args);
	}

}
