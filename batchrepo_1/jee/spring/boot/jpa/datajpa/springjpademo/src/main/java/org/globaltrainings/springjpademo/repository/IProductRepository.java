package org.globaltrainings.springjpademo.repository;


import org.globaltrainings.springjpademo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository  extends JpaRepository<Product,Integer> {

    List<Product> findByPrice(double price);

    List<Product> findByPriceOrderByNameDesc(double price);

    @Query("from Product where price=:priceArg order by name desc ")
    List<Product> findByPriceAndOrderByNameInDescending(@Param("priceArg") double price);

    //because product name is unique
    Optional<Product>findProductByName(String name);

    List<Product>findByNameOrPrice(String name, double price);



}
