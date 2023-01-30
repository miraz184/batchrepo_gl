package org.globaltrainings.saleapp.customerms.controllers;

import org.globaltrainings.saleapp.customerms.dto.BuyProductRequest;
import org.globaltrainings.saleapp.customerms.dto.CustomerDetails;
import org.globaltrainings.saleapp.customerms.dto.RegisterCustomer;
import org.globaltrainings.saleapp.customerms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/customers")
@RestController
public class CustomerController {

    private ICustomerService service;

    @Autowired
    public CustomerController(ICustomerService service){
        this.service=service;
    }

    @PostMapping(value = "/add")
    public CustomerDetails register(@RequestBody RegisterCustomer request){
       CustomerDetails response= service.register(request);
       return response;
    }

    @GetMapping("/byid/{id}")
    public CustomerDetails fetchCustomerById(@PathVariable long id) throws Exception{
        CustomerDetails response=service.findCustomerDetailsById(id);
        return response;
    }

    @PutMapping("/buy")
    public CustomerDetails buyProduct(@RequestBody BuyProductRequest request) throws Exception{
        CustomerDetails response=service.buyProduct(request);
        return response;
    }

}
