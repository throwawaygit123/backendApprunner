package com.quanbio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//  Could use the @bean of RestTemplate here instead of in a separated class 
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

}
