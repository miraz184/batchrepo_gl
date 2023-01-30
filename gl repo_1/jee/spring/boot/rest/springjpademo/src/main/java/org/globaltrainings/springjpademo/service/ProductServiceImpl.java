package org.globaltrainings.springjpademo.service;


import org.globaltrainings.springjpademo.dao.IProductDao;
import org.globaltrainings.springjpademo.dto.AddProduct;
import org.globaltrainings.springjpademo.dto.ChangePriceRequestDto;
import org.globaltrainings.springjpademo.dto.ProductDetails;
import org.globaltrainings.springjpademo.entity.Product;
import org.globaltrainings.springjpademo.exceptions.InvalidArgumentException;
import org.globaltrainings.springjpademo.exceptions.ProductNotFoundException;
import org.globaltrainings.springjpademo.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements IProductService {

    private IProductDao productDao ;
    private ProductUtil util;

    @Autowired
    public ProductServiceImpl(IProductDao dao, ProductUtil util){
        this.productDao=dao;
        this.util=util;
    }


    @Transactional
    @Override
    public ProductDetails addProduct(AddProduct requestData) throws InvalidArgumentException {
        Product product = new Product();
        product.setName(requestData.getName());
        product.setPrice(requestData.getPrice());
        productDao.add(product);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    @Transactional(readOnly = true)
    @Override
    public ProductDetails findProductDetailsById(int id) throws InvalidArgumentException, ProductNotFoundException {
        Product product=findById(id);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    public Product findById(int id) throws InvalidArgumentException, ProductNotFoundException {
        Optional<Product> optional = productDao.findById(id);
        if(optional.isEmpty()){
            throw new ProductNotFoundException("product not found for id="+id);
        }
        Product product=optional.get();
        return product;
    }


    @Transactional
    @Override
    public ProductDetails changePrice(ChangePriceRequestDto requestData) throws InvalidArgumentException, ProductNotFoundException {
        Product product=findById(requestData.getId());
        product.setPrice(requestData.getNewPrice());
        product=productDao.update(product);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductDetails>fetchProductsOrderByPrice(){
      List<Product>products=  productDao.fetchAllProductsByPrice();
      List<ProductDetails>desired=util.toProductDetailsList(products);
      return desired;
    }

}
