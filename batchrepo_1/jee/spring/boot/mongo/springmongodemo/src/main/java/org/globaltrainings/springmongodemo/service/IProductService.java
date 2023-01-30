package org.globaltrainings.springmongodemo.service;


import org.globaltrainings.springmongodemo.dto.AddProduct;
import org.globaltrainings.springmongodemo.dto.ChangePriceRequestDto;
import org.globaltrainings.springmongodemo.dto.ProductDetails;
import org.globaltrainings.springmongodemo.exceptions.InvalidArgumentException;
import org.globaltrainings.springmongodemo.exceptions.ProductNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Validated
public interface IProductService {

    ProductDetails addProduct(@Valid AddProduct requestData) throws InvalidArgumentException;

    ProductDetails findProductDetailsById(@NotBlank String id) throws InvalidArgumentException, ProductNotFoundException;

    ProductDetails changePrice(@Valid ChangePriceRequestDto requestData) throws InvalidArgumentException, ProductNotFoundException;

    List<ProductDetails> fetchProductsOrderByPrice();
}
