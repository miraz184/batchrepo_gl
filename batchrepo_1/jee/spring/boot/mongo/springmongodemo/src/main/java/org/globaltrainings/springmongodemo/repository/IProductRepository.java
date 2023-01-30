package org.globaltrainings.springmongodemo.repository;


import org.globaltrainings.springmongodemo.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends MongoRepository<Product,String> {




}
