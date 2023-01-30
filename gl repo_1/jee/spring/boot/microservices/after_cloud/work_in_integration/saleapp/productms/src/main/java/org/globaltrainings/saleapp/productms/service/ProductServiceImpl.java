package org.globaltrainings.saleapp.productms.service;


import org.globaltrainings.saleapp.productms.dto.AddProduct;
import org.globaltrainings.saleapp.productms.dto.ChangePriceRequestDto;
import org.globaltrainings.saleapp.productms.dto.ProductDetails;
import org.globaltrainings.saleapp.productms.entity.Product;
import org.globaltrainings.saleapp.productms.exceptions.InvalidArgumentException;
import org.globaltrainings.saleapp.productms.exceptions.ProductNotFoundException;
import org.globaltrainings.saleapp.productms.repository.IProductRepository;
import org.globaltrainings.saleapp.productms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepository repo;
    private ProductUtil util;

    @Autowired
    public ProductServiceImpl(IProductRepository repo, ProductUtil util){
        this.repo =repo;
        this.util=util;
    }


    @Transactional
    @Override
    public ProductDetails addProduct(AddProduct requestData)  {
        Product product = new Product();
        product.setName(requestData.getName());
        product.setPrice(requestData.getPrice());
        product=repo.save(product);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    @Transactional(readOnly = true)
    @Override
    public ProductDetails findProductDetailsById(int id) throws   ProductNotFoundException {
        Product product=findById(id);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    public Product findById(int id)  throws ProductNotFoundException {
        Optional<Product> optional = repo.findById(id);
        if(optional.isEmpty()){
            throw new ProductNotFoundException("product not found for id="+id);
        }
        Product product=optional.get();
        return product;
    }


    @Transactional
    @Override
    public ProductDetails changePrice(ChangePriceRequestDto requestData) throws ProductNotFoundException {
        Product product=findById(requestData.getId());
        product.setPrice(requestData.getNewPrice());
        product= repo.save(product);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductDetails>fetchProductsOrderByPrice(){
      List<Product>products=  repo.findAll(Sort.by("price"));
      List<ProductDetails>desired=util.toProductDetailsList(products);
      return desired;
    }

}
