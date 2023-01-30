package org.globaltrainings.springjpademo.util;

import org.globaltrainings.springjpademo.dto.ProductDetails;
import org.globaltrainings.springjpademo.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductUtil {

    public ProductDetails toProductDetails(Product product){
        ProductDetails desired=new ProductDetails();
        desired.setId(product.getId());
        desired.setPrice(product.getPrice());
        desired.setName(product.getName());
        return desired;
    }

    public List<ProductDetails> toProductDetailsList(Collection<Product> products){
      List<ProductDetails>list=  products.stream()
                .map(this::toProductDetails)
                .collect(Collectors.toList());
      return list;
    }

}
