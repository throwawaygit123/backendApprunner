package com.quanbio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.quanbio.mapper")
@EnableTransactionManagement
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
