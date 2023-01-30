package com.gltraining.mvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AppController {

    private Map<Integer,User>store=new HashMap<>();

    public AppController(){
        store.put(1, new User(1,"mirazul"));
        store.put(2,new User(2, "rutwik"));
        store.put(3,new User(3,"lakshmi"));
    }


    private int counter;

    @GetMapping("/")
    public ModelAndView indexPage(){
        counter++;
        System.out.println("inside Controller method indexPage");
        ModelAndView modelAndView=new ModelAndView("home","renderCount",counter);
        return modelAndView;

    }

    @GetMapping("/listall")
    public ModelAndView allUsers(){
        Collection<User> users=store.values();
        ModelAndView modelAndView=new ModelAndView("listusers","users",users);
        return modelAndView;
    }


    //   /profile?id=1
    @GetMapping("/profile")
    public ModelAndView profilePage(@RequestParam int id){
        System.out.println("inside profilePage id="+id);
        User user=store.get(id);
        ModelAndView modelAndView=new ModelAndView("profile","user",user);
        return modelAndView;
    }

    @GetMapping("/topusers")
    public ModelAndView topUsers(){
        ModelAndView modelAndView=new ModelAndView("topusers");
        return modelAndView;
    }



}
