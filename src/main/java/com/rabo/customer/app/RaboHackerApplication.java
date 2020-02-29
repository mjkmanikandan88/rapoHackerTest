package com.rabo.customer.app;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RaboHackerApplication {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(RaboHackerApplication.class.getName());
		//System.setProperty("spring.config.name", "addition-server");
		SpringApplication.run(RaboHackerApplication.class, args);
		logger.info("HackerApplication Application Started Successfully");
	}

}
