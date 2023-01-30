package org.globaltrainings.springjpademo.controllers;

import org.globaltrainings.springjpademo.dto.AddProduct;
import org.globaltrainings.springjpademo.dto.ProductDetails;
import org.globaltrainings.springjpademo.service.IProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProductRestControllerUnitTest {


    @Mock
    IProductService service;

    @InjectMocks
    @Spy
    ProductRestController controller;

    @Test
    public void testAdd_1() throws Exception{
        ProductDetails response=mock(ProductDetails.class);
        AddProduct requestDTO= mock(AddProduct.class);
        when(service.addProduct(requestDTO)).thenReturn(response);
        ProductDetails result =controller.add(requestDTO);
        assertEquals(response,result);
        verify(service).addProduct(requestDTO);
    }

}