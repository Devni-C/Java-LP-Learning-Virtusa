package com.devni.tlp.finalproject.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookServiceApplication {

	public static final int MAX_LENT_BOOKS = 1;
	public static final int MAX_LENT_BOOKS_PER_PERSON = 2;

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}
