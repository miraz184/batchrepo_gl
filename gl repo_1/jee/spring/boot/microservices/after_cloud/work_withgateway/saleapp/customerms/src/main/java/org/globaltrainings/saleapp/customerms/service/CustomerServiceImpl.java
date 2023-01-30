package org.globaltrainings.saleapp.customerms.service;

import org.globaltrainings.saleapp.customerms.dto.BuyProductRequest;
import org.globaltrainings.saleapp.customerms.dto.CustomerDetails;
import org.globaltrainings.saleapp.customerms.dto.RegisterCustomer;
import org.globaltrainings.saleapp.customerms.entity.Customer;
import org.globaltrainings.saleapp.customerms.exceptions.CustomerNotFoundException;
import org.globaltrainings.saleapp.customerms.repository.ICustomerRepository;
import org.globaltrainings.saleapp.customerms.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository customerRepo;

    private CustomerUtil customerUtil;


    @Autowired
    public CustomerServiceImpl(ICustomerRepository customerRepo, CustomerUtil customerUtil){
        this.customerRepo=customerRepo;
        this.customerUtil=customerUtil;
    }


    @Override
    public CustomerDetails register(RegisterCustomer register) {
        Customer customer=new Customer();
        customer.setName(register.getName());
        customer=customerRepo.save(customer);
        return customerUtil.toCustomerDetails(customer);
    }

    @Override
    public CustomerDetails findCustomerDetailsById(long customerId) throws CustomerNotFoundException {
        Customer customer=findById(customerId);
        return customerUtil.toCustomerDetails(customer);
    }

    Customer findById(long id) throws CustomerNotFoundException{
     Optional<Customer>optional= customerRepo.findById(id);
     if(optional.isEmpty()){
         throw new CustomerNotFoundException("customer not found");
     }
     return optional.get();
    }


    @Override
    public CustomerDetails buyProduct(BuyProductRequest buyRequest)throws CustomerNotFoundException {
       Customer customer= findById(buyRequest.getCustomerId());
       Set<Integer> products= customer.getPurchasedProducts();
       if(products==null){
           products=new HashSet<>();
           customer.setPurchasedProducts(products);
       }
       products.add(buyRequest.getProductId());
       customerRepo.save(customer);
        return customerUtil.toCustomerDetails(customer);
    }
}
