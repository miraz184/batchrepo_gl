package org.globaltrainings.dao;

import org.globaltrainings.entity.Product;

import java.util.Optional;

public interface IProductDao {

    boolean add(Product product);

    Optional<Product> findById(int id);

    boolean update(Product product);

}
