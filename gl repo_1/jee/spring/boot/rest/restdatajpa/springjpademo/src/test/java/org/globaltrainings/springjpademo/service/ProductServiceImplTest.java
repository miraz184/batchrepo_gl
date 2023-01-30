package org.globaltrainings.springjpademo.service;

import org.globaltrainings.springjpademo.entity.Product;
import org.globaltrainings.springjpademo.exceptions.InvalidArgumentException;
import org.globaltrainings.springjpademo.exceptions.ProductNotFoundException;
import org.globaltrainings.springjpademo.repository.IProductRepository;
import org.globaltrainings.springjpademo.util.ProductUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplUnitTest {

    @Mock
    IProductRepository repo;

    @Mock
    ProductUtil util;

    @InjectMocks
    @Spy
    ProductServiceImpl service;

    /**
     *
     * Scenario: product exists and found
     * input: id 1
     * verifying: repo.findById(id) called once
     *
     */
    @Test
    public void testFindById_1() throws Exception {
        int inputId = 1;
        Product product = mock(Product.class);
        Optional<Product> optional = Optional.of(product);
        when(repo.findById(inputId)).thenReturn(optional);
        Product result = service.findById(inputId);
        assertEquals(product, result);
        verify(repo).findById(inputId);
    }

    /**
     * Scenario: Product does not exist
     *
     */
    @Test
    public void testFindById_2() throws Exception {
        int inputId = 10;
        Optional<Product> optional = Optional.empty();
        when(repo.findById(inputId)).thenReturn(optional);
        Executable execute=()->service.findById(inputId);
        assertThrows(ProductNotFoundException.class,execute);

    }



}