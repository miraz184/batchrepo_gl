package org.globaltrainings.springjpademo.controllers;

import org.globaltrainings.springjpademo.entity.Product;
import org.globaltrainings.springjpademo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    private IProductService service;

    @Autowired
    public EmployeeController(IProductService service){
        this.service=service;
    }


    private int count;

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("home","renderCount",++count);
    }

    @GetMapping("/product")
    public ModelAndView productDetails(@RequestParam int id) throws  Exception{
       Product product =service.findById(id);
       ModelAndView modelAndView=new ModelAndView("product","product",product);
       return modelAndView;
    }

    @GetMapping("/allproducts")
    public ModelAndView listProducts(){
        List<Product> list= service.fetchProductsOrderByPrice();
        ModelAndView modelAndView=new ModelAndView("listproducts","products",list);
        return modelAndView;
    }


    @GetMapping("/findproduct")
    public ModelAndView findProduct(){
        return new ModelAndView("findproduct");
    }

    @GetMapping("/processAddProduct")
    public ModelAndView addProduct(@RequestParam String name, @RequestParam double price) throws  Exception{
        Product product=service.addProduct(name,price);
        ModelAndView modelAndView=new ModelAndView("product","product",product);
        return modelAndView;
    }


    @GetMapping("/addproduct")
    public  ModelAndView addProduct(){
        return new ModelAndView("addproduct");
    }


}
