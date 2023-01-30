package org.globaltrainings.dao;

import org.globaltrainings.entity.Product;

import java.util.Optional;

public interface IProductDao {

    void add(Product product);

    Optional<Product> findById(int id);

    void update(Product product);

}
