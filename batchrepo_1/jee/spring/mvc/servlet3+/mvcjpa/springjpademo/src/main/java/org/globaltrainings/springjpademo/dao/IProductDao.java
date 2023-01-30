package org.globaltrainings.springjpademo.dao;

import org.globaltrainings.springjpademo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductDao {

    void add(Product product);

    Optional<Product> findById(int id);

    Product update(Product product);

    List<Product> fetchAllProductsByPrice();

}
