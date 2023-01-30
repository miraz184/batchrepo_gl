package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(DemoApplication.class, args);
		RestTemplateExperiments experiments=context.getBean(RestTemplateExperiments.class);
		experiments.fireRequests();
		context.close();
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
