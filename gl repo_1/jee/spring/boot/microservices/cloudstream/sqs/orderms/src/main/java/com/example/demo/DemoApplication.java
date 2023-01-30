package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(DemoApplication.class, args);
		Map<String, Integer>map=new HashMap<>();
		map.put("phone",2);
		map.put("charger",1);
		CreateOrderDto order=new CreateOrderDto();
		order.setItems(map);
		Jackson2JsonObjectMapper mapper=new Jackson2JsonObjectMapper();
		String json=mapper.toJson(order);
		System.out.println("json ="+json);
	}


	@Bean
	public Function<String,String> uppercaseFn(){
		return str->{
			System.out.println("inside function received msg="+str);
			return str.toUpperCase();
		};
	}

	@Bean
	public Function<CreateOrderDto, CreateDeliveryDto> createOrder(){
		Function<CreateOrderDto, CreateDeliveryDto>function= orderDto->{
			CreateDeliveryDto delivery=new CreateDeliveryDto();
			delivery.setItems(orderDto.getItems());
		    delivery.setOrderDate(LocalDate.now().toString());
			System.out.println("order item="+orderDto.getItems());
			System.out.println("sent to be processed for delivery");
			return delivery;
		};
		return function;
	}



}
