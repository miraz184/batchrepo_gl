package org.globaltrainings.dao;


import org.globaltrainings.datastore.ProductStore;
import org.globaltrainings.entity.Product;

import java.util.Optional;

public class ProductDaoImpl implements IProductDao{
    @Override
    public void add(Product product) {
        ProductStore.map.put(product.getId(),product);
    }

    @Override
    public Optional<Product> findById(int id) {
       Product product= ProductStore.map.get(id);
       if(product==null){
           Optional<Product> optional=Optional.empty();
           return optional;
       }
       return Optional.of(product);
    }

    @Override
    public void update(Product product){
        ProductStore.map.put(product.getId(),product);

    }

}
