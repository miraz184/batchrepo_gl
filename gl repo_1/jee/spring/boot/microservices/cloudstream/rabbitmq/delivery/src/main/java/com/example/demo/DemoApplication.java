package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.function.Consumer;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	public Consumer<CreateDeliveryDto> delivery(){
		Consumer< CreateDeliveryDto>function= delivery->{
			System.out.println("delivery items="+delivery.getItems());
			System.out.println("order date was "+delivery.getOrderDate());
		};
		return function;
	}

}
