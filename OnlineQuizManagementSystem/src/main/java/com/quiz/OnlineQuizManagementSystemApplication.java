package com.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineQuizManagementSystemApplication {
	private static final Logger LOG = LoggerFactory.getLogger(OnlineQuizManagementSystemApplication.class);

	public static void main(String[] args) {
				SpringApplication.run(OnlineQuizManagementSystemApplication.class, args);
				LOG.info("Connected with Port: 8082");
	}
}
