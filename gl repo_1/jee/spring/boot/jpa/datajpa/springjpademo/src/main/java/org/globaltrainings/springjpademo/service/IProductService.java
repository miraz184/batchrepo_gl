package org.globaltrainings.springjpademo.service;


import org.globaltrainings.springjpademo.entity.Product;
import org.globaltrainings.springjpademo.exceptions.InvalidArgumentException;
import org.globaltrainings.springjpademo.exceptions.ProductNotFoundException;

import java.util.List;

public interface IProductService {

    Product addProduct(String name, double price) throws InvalidArgumentException;

    Product findById(int id) throws InvalidArgumentException, ProductNotFoundException;

    Product changePrice(int id, double newPrice) throws InvalidArgumentException, ProductNotFoundException;
/*
    List<Product> fetchProductsOrderByPrice();
  */

  List<Product>fetchAll();

    List<Product> findProductsByPrice(double price);

    Product findByName(String name)throws ProductNotFoundException;

    List<Product> findProductsByPriceWithNameDescending(double price);

    boolean removeProduct(int id);

}
