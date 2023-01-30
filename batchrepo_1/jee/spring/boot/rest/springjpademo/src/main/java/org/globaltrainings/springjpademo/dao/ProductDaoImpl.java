package org.globaltrainings.springjpademo.dao;


import org.globaltrainings.springjpademo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDaoImpl implements IProductDao {

    @PersistenceContext
    //@Autowired
    private EntityManager entityManager;

    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        Product product = entityManager.find(Product.class, id);
        if (product == null) {
            return Optional.empty();
        }
        return Optional.of(product);
    }

    @Override
    public Product update(Product product) {
        product = entityManager.merge(product);
        return product;
    }

    @Override
    public List<Product> fetchAllProductsByPrice(){
        String queryText="from Product order by price";
        TypedQuery<Product>query =entityManager.createQuery(queryText,Product.class);
        List<Product>list=query.getResultList();
        return list;
    }

}
