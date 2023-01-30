package com.gltrainings.securedemo.controllers;

import com.gltrainings.securedemo.dto.AddCustomer;
import com.gltrainings.securedemo.dto.CustomerDetails;
import com.gltrainings.securedemo.dto.LoginRequest;
import com.gltrainings.securedemo.service.ICustomerService;
import com.gltrainings.securedemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {

    private ICustomerService customerService;


    @Autowired
    public CustomerController(ICustomerService service){
        this.customerService =service;

    }

    @PostMapping("/p/customers/add")
    public CustomerDetails register(@RequestBody  AddCustomer requestData){
        return customerService.register(requestData);
    }


    @GetMapping("/c/customers/byusername/{username}")
    public CustomerDetails fetchCustomer(@PathVariable String username){
        return customerService.findByUserName(username);
    }


    @GetMapping("/a/customers")
    public List<CustomerDetails> fetchAllCustomers(){
        return customerService.findAll();
    }


}
