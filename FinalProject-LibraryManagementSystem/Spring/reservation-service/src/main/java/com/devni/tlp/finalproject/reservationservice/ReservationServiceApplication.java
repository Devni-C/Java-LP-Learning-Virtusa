package com.devni.tlp.finalproject.reservationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReservationServiceApplication {
	public static final int NO_OF_DAYS_A_BOOK_CAN_KEEP = 14;
	public static final int MAX_BOOKS_TO_RESERVE = 5;
	public static final int MAX_BOOKS_TO_LEND = 2;

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}

}
