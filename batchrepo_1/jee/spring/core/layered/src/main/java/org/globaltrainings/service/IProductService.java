package org.globaltrainings.service;


import org.globaltrainings.entity.Product;
import org.globaltrainings.exceptions.InvalidArgumentException;
import org.globaltrainings.exceptions.ProductNotFoundException;

public interface IProductService {

    Product addProduct(String name, double price) throws InvalidArgumentException;

    Product findById(int id) throws InvalidArgumentException, ProductNotFoundException;

    Product changePrice(int id, double newPrice) throws InvalidArgumentException,  ProductNotFoundException;


}
