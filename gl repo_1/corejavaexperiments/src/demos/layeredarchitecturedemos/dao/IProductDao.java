package demos.layeredarchitecturedemos.dao;

import demos.layeredarchitecturedemos.entity.Product;

import java.util.Optional;

public interface IProductDao {

    void add(Product product);

    Optional<Product> findById(int id);

    void update(Product product);

}
