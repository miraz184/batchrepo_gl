package com.gltrainings.securedemo.service;

import com.gltrainings.securedemo.dto.AddCustomer;
import com.gltrainings.securedemo.dto.CustomerDetails;
import com.gltrainings.securedemo.entity.Customer;
import com.gltrainings.securedemo.entity.User;
import com.gltrainings.securedemo.repository.ICustomerRepository;
import com.gltrainings.securedemo.repository.UserRepository;
import com.gltrainings.securedemo.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerUtil customerUtil;

    @Autowired
    private ICustomerRepository customerRepo;

  //  @Autowired
   // private UserRepository userRepo;

    @Transactional
    public CustomerDetails register(AddCustomer requestData) {
        User user = new User();
        user.setUsername(requestData.getUsername());
        user.setPassword(requestData.getPassword());
        Set<String> roles=new HashSet<>();
        roles.add("CUSTOMER");
        user.setRoles(roles);
       // user=userRepo.save(user);
        Customer customer = new Customer();
        customer.setUser(user);
        customer = customerRepo.save(customer);
        return customerUtil.customerDetails(customer);

    }

    @Override
    public CustomerDetails findByUserName(String username){
      Optional<Customer>optional= customerRepo.findByUsername(username);
      if(!optional.isPresent()){
          throw new UsernameNotFoundException("user not found by username="+username);
      }
        return customerUtil.customerDetails(optional.get());
    }

    @Override
    public List<CustomerDetails>findAll(){
        List<Customer>list= customerRepo.findAll();
        return customerUtil.toDetailsList(list);
    }


}
