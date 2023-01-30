package org.globaltrainings.saleapp.productms.util;

import org.globaltrainings.saleapp.productms.dto.ProductDetails;
import org.globaltrainings.saleapp.productms.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Collection;
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
