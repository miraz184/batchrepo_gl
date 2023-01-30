package org.globaltrainings.springjpademo.service;


import org.globaltrainings.springjpademo.entity.Product;
import org.globaltrainings.springjpademo.exceptions.InvalidArgumentException;
import org.globaltrainings.springjpademo.exceptions.ProductNotFoundException;
import org.globaltrainings.springjpademo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepository repo;

    @Autowired
    public ProductServiceImpl(IProductRepository repo){
        this.repo =repo;
    }


    @Transactional
    @Override
    public Product addProduct(String name, double price) throws InvalidArgumentException {
        name.toLowerCase().trim();
        validateStringNotBlank(name, "name can't empty");
        validateDoubleNotNegative(price, "price can bt smaller thnan zero");
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product=repo.save(product);
        return product;
    }

    @Transactional(readOnly = true)
    @Override
    public Product findById(int id) throws InvalidArgumentException, ProductNotFoundException {
        validateIntegerNOTotNegative(id, "id can't be smaller than zer");
        Optional<Product> optional = repo.findById(id);
        if(optional.isEmpty()){
            throw new ProductNotFoundException("product not found for id="+id);
        }
        return optional.get();
    }

    @Transactional
    @Override
    public Product changePrice(int id, double newPrice) throws InvalidArgumentException, ProductNotFoundException {
        validateIntegerNOTotNegative(id, "id can't be smaller than zer");
        validateDoubleNotNegative(newPrice,"newprice can't be negative");
        Product product=findById(id);
        product.setPrice(newPrice);
        repo.save(product);
        return product;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> fetchAll() {
       List<Product>list =repo.findAll();
       return list;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findProductsByPrice(double price){
        List<Product>list=repo.findByPrice(price);
        return list;
    }



    @Transactional(readOnly = true)
    @Override
    public List<Product> findProductsByPriceWithNameDescending(double price){
        List<Product>list=repo.findByPriceOrderByNameDesc(price);
        return list;
    }



    @Transactional(readOnly = true)
    @Override
    public Product findByName(String name)throws ProductNotFoundException{
      Optional<Product>optional=  repo.findProductByName(name);
        if(optional.isEmpty()){
            throw new ProductNotFoundException("product not found for name="+name);
        }
        return optional.get();
    }

    @Override
    public boolean removeProduct(int id) {
        repo.deleteById(id);
        return true;
    }

    /*
            @Transactional(readOnly = true)
            @Override
            public List<Product>fetchProductsOrderByPrice(){
              List<Product>products=  repo.fetchAllProductsByPrice();
              return products;
            }
        */
    void validateStringNotBlank(String input, String msg) throws InvalidArgumentException {
        if (input.isBlank()) {
            throw new InvalidArgumentException(msg);
        }
    }

    void validateDoubleNotNegative(double input, String msg) throws InvalidArgumentException {
        {
            if (input < 0) {
                throw new InvalidArgumentException(msg);
            }
        }
    }


    void validateIntegerNOTotNegative(int input, String msg) throws InvalidArgumentException {
        {
            if (input < 0) {
                throw new InvalidArgumentException(msg);
            }
        }
    }

}
