package com.gltrainings.securedemo.service;

import com.gltrainings.securedemo.dto.AddCustomer;
import com.gltrainings.securedemo.dto.CustomerDetails;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface ICustomerService {

    CustomerDetails register(@Valid AddCustomer requestData);
    CustomerDetails findByUserName(String username);

    List<CustomerDetails> findAll();

}
