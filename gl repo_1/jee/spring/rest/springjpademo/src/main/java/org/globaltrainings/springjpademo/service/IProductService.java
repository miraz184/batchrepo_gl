package org.globaltrainings.springjpademo.service;


import org.globaltrainings.springjpademo.dto.AddProduct;
import org.globaltrainings.springjpademo.dto.ChangePriceRequestDto;
import org.globaltrainings.springjpademo.dto.ProductDetails;
import org.globaltrainings.springjpademo.entity.Product;
import org.globaltrainings.springjpademo.exceptions.InvalidArgumentException;
import org.globaltrainings.springjpademo.exceptions.ProductNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


public interface IProductService {

    ProductDetails addProduct(AddProduct requestData) throws InvalidArgumentException;

    ProductDetails findProductDetailsById(int id) throws InvalidArgumentException, ProductNotFoundException;

    ProductDetails changePrice( ChangePriceRequestDto requestData) throws InvalidArgumentException, ProductNotFoundException;

    List<ProductDetails> fetchProductsOrderByPrice();
}
