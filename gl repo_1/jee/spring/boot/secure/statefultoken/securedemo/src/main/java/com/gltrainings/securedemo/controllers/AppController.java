package com.gltrainings.securedemo.controllers;

import com.gltrainings.securedemo.dto.LoginRequest;
import com.gltrainings.securedemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private IUserService service;

    @Autowired
    public AppController(IUserService service){
        this.service=service;
    }

    @GetMapping("/success")
    public String successfulLogin(){
        return "You are successfully logged in";
    }


}
