package com.gltrainings.securedemo.util;

import com.gltrainings.securedemo.dto.CustomerDetails;
import com.gltrainings.securedemo.entity.Customer;
import com.gltrainings.securedemo.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerUtil {

    public CustomerDetails customerDetails(Customer customer) {
        User user = customer.getUser();
        CustomerDetails desired = new CustomerDetails();
        desired.setCustomerId(customer.getId());
        desired.setRoles(user.getRoles());
        desired.setUsername(user.getUsername());
        return desired;
    }

    public List<CustomerDetails> toDetailsList(Collection<Customer>customers){
      List<CustomerDetails>list=  customers.stream()
                .map(this::customerDetails)
                .collect(Collectors.toList());
      return list;
    }

}
