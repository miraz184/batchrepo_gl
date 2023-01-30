package com.example.orderms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrderController {

    @GetMapping("/all")
    public List<String>all(){
        List<String>list=new ArrayList<>();
        list.add("samsung order");
        list.add("motorola order");
        list.add("htc order");
        return list;
    }


}
