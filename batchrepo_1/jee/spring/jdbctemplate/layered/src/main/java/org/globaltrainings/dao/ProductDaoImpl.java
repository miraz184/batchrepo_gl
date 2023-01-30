package org.globaltrainings.dao;


import org.globaltrainings.entity.Product;
import org.globaltrainings.util.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductDaoImpl implements IProductDao {

    private int generatedId;


    private JdbcTemplate template;

    @Autowired
    public ProductDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    public int generateId() {
        return ++generatedId;
    }

    private final String insertQuery="insert into products(id,name,price) values(?,?,?)";
    private final String fetchProductQuery="select * from products where id=?";
    private final String updateProductQuery="update products set name=?, price=? where id=?" ;

    @Override
    public boolean add(Product product) {
        int newId = generateId();
        int rows = template.update(insertQuery, newId, product.getName(), product.getPrice());
        return rows>0;
    }

    @Override
    public Optional<Product> findById(int id) {
        Product product = template.queryForObject(fetchProductQuery, new ProductRowMapper(), id);
        if (product == null) {
            Optional<Product> optional = Optional.empty();
            return optional;
        }
        return Optional.of(product);
    }

    @Override
    public  boolean update(Product product) {
        int rows = template.update(updateProductQuery, product.getName(), product.getPrice(), product.getId());
        return rows>0;
    }


}
