package com.quanbio;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages ="com.quanbio.model")
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
