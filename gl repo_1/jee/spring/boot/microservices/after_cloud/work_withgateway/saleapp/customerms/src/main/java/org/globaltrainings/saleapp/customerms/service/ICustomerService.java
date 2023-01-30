package org.globaltrainings.saleapp.customerms.service;


import org.globaltrainings.saleapp.customerms.dto.BuyProductRequest;
import org.globaltrainings.saleapp.customerms.dto.CustomerDetails;
import org.globaltrainings.saleapp.customerms.dto.RegisterCustomer;
import org.globaltrainings.saleapp.customerms.exceptions.CustomerNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
public interface ICustomerService {

    CustomerDetails register(@Valid RegisterCustomer register);

    CustomerDetails findCustomerDetailsById(@Min(1)long customerId) throws CustomerNotFoundException;

    CustomerDetails buyProduct(@Valid BuyProductRequest butRequest) throws CustomerNotFoundException;

}
