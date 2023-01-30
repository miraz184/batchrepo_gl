package org.globaltrainings.springjpademo.service;


import org.globaltrainings.springjpademo.dao.IProductDao;
import org.globaltrainings.springjpademo.entity.Product;
import org.globaltrainings.springjpademo.exceptions.InvalidArgumentException;
import org.globaltrainings.springjpademo.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements IProductService {

    private IProductDao productDao ;

    @Autowired
    public ProductServiceImpl(IProductDao dao){
        this.productDao=dao;
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
        productDao.add(product);
        return product;
    }

    @Transactional(readOnly = true)
    @Override
    public Product findById(int id) throws InvalidArgumentException, ProductNotFoundException {
        validateIntegerNOTotNegative(id, "id can't be smaller than zer");
        Optional<Product> optional = productDao.findById(id);
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
        productDao.update(product);
        return product;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product>fetchProductsOrderByPrice(){
      List<Product>products=  productDao.fetchAllProductsByPrice();
      return products;
    }

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
