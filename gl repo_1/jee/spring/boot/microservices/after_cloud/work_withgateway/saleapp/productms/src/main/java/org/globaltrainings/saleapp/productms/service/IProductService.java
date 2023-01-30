package org.globaltrainings.saleapp.productms.service;


import org.globaltrainings.saleapp.productms.dto.AddProduct;
import org.globaltrainings.saleapp.productms.dto.ChangePriceRequestDto;
import org.globaltrainings.saleapp.productms.dto.ProductDetails;
import org.globaltrainings.saleapp.productms.entity.Product;
import org.globaltrainings.saleapp.productms.exceptions.InvalidArgumentException;
import org.globaltrainings.saleapp.productms.exceptions.ProductNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


@Validated
public interface IProductService {

    ProductDetails addProduct(@Valid AddProduct requestData);

    ProductDetails findProductDetailsById(@Min(1)int id) throws ProductNotFoundException;

    ProductDetails changePrice(@Valid ChangePriceRequestDto requestData) throws ProductNotFoundException;

    List<ProductDetails> fetchProductsOrderByPrice();

    Product findById(int id) throws  ProductNotFoundException;
}
