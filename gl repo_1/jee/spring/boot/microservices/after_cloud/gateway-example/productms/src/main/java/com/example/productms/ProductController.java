package com.example.productms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    @GetMapping("/all")
    public List<String>all(){
        List<String>list=new ArrayList<>();
        list.add("samsung");
        list.add("motorola");
        list.add("htc");
        return list;
    }

    @GetMapping("/best")
    public String topProduct(){
        return "mototrola";
    }


}
