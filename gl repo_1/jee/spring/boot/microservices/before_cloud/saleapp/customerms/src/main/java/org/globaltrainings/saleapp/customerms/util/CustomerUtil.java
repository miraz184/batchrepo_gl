package org.globaltrainings.saleapp.customerms.util;

import org.globaltrainings.saleapp.customerms.dto.CustomerDetails;
import org.globaltrainings.saleapp.customerms.dto.ProductDetailsDTO;
import org.globaltrainings.saleapp.customerms.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
public class CustomerUtil {

    @Value("${productms.baseurl}")
    private String baseProductUrl;

    private RestTemplate restTemplate;

    @Autowired
    public CustomerUtil(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }


    public CustomerDetails toCustomerDetails(Customer customer){
        CustomerDetails desired=new CustomerDetails();
        desired.setId(customer.getId());
        desired.setName(customer.getName());
        Set<Integer> productsId=customer.getPurchasedProducts();
        if(productsId!=null){
         List<ProductDetailsDTO>desiredProducts=  fetchProductDetailsList(productsId);
         desired.setPurchasedProducts(desiredProducts);
        }
        return desired;
    }

    public List<ProductDetailsDTO>fetchProductDetailsList(Collection<Integer>productsId){
           List<ProductDetailsDTO>list=new ArrayList<>();
           for (int productId:productsId){
               ProductDetailsDTO product=fetchProductDetails(productId);
               list.add(product);
           }
           return list;
    }

    public ProductDetailsDTO  fetchProductDetails(int productId){
        String url=baseProductUrl+"/products/byid/"+productId;
        ProductDetailsDTO response=restTemplate.getForObject(url,ProductDetailsDTO.class);
        return response;
    }

}
