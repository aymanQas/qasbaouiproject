package com.example.qasbaouiproject;

import com.example.qasbaouiproject.dao.entities.Product;
import com.example.qasbaouiproject.dao.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication

public class QasbaouiprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(QasbaouiprojectApplication.class, args);
	}
	@Bean
	public CommandLineRunner startDAO(ProductRepository productRepository) {
		return args -> {
			Product product = new Product();

		};
	}
}
