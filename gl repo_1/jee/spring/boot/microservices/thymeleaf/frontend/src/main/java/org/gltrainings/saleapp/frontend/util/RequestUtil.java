package org.gltrainings.saleapp.frontend.util;

import org.gltrainings.saleapp.frontend.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RequestUtil {

    @Value("${gateway.url}")
    private String gatewayUrl;

    @Autowired
    private RestTemplate restTemplate;


    public List<ProductDetails> fetchAllProductsByPrice() {
        String url = gatewayUrl + "/products/order/byprice";
        ProductDetails array[]=restTemplate.getForObject(url,ProductDetails[].class );
        List<ProductDetails>list= Stream.of(array).collect(Collectors.toList());
        return list;
    }

}
