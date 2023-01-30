package org.globaltrainings.saleapp.customerms.util;

import org.globaltrainings.saleapp.customerms.dto.CustomerDetails;
import org.globaltrainings.saleapp.customerms.entity.Customer;
import org.globaltrainings.saleapp.productms.dto.ProductDetails;
import org.globaltrainings.saleapp.productms.entity.Product;
import org.globaltrainings.saleapp.productms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class CustomerUtil {

    @Autowired
    private ProductUtil productUtil;

    public CustomerDetails toCustomerDetails(Customer customer){
        CustomerDetails desired=new CustomerDetails();
        desired.setId(customer.getId());
        desired.setName(customer.getName());
        Set<Product> products=customer.getPurchasedProducts();
        if(products!=null){
         List<ProductDetails>desiredProducts=  productUtil.toProductDetailsList(products);
         desired.setPurchasedProducts(desiredProducts);
        }
        return desired;
    }

}
