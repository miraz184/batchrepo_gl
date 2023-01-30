package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private StreamBridge bridge;

    @PutMapping("/send/{msg}")
    public void sendInTopic(@PathVariable String msg)
    {
        System.out.println("received msg in controller "+msg);
        bridge.send("uppercaseFn-in-0",msg);
    }

    @PostMapping("/orders/add")
    public String addOrder(@RequestBody CreateOrderDto createOrder){
        System.out.println("order received");
        bridge.send("createOrder-in-0",createOrder);
        return "order received";
    }

}
