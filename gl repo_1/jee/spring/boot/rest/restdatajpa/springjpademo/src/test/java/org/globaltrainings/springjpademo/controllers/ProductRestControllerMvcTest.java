package org.globaltrainings.springjpademo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.globaltrainings.springjpademo.dto.ProductDetails;
import org.globaltrainings.springjpademo.exceptions.ProductNotFoundException;
import org.globaltrainings.springjpademo.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductRestController.class)
public class ProductRestControllerMvcTest {

    @MockBean
    IProductService service;

    @Autowired
    MockMvc mvc;


    /**
     *  scenario: product is found
     *  input id: 10
     *  expectation: status is OK and responsebody is json of productdetails
     *
     */
    @Test
    public void fetchProductById_1() throws Exception{
        int id=10;
        ProductDetails response=new ProductDetails();
        response.setId(id);
        response.setName("samsung");
        response.setPrice(10000);
        when(service.findProductDetailsById(id)).thenReturn(response);
        String uri="/products/byid/10";
        ObjectMapper mapper=new ObjectMapper();
        String responseBodyJson=mapper.writeValueAsString(response);
        mvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(content().json(responseBodyJson));
    }


    /**
     *  scenario: product NOT found
     *  input id: 10
     *  expectation: status is NOT_FOUND and responsebody is text "product not found for id=10"
     *
     */
    @Test
    public void fetchProductById_2() throws Exception {
        int id = 10;
        String uri = "/products/byid/10";
        String  responseBody="product not found for id=10";
        ProductNotFoundException exception=new ProductNotFoundException(responseBody);
        when(service.findProductDetailsById(id)).thenThrow(exception);
        mvc.perform(get(uri))
                .andExpect(status().isNotFound())
                .andExpect(content().string(responseBody));

    }


}
