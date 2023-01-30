package org.globaltrainings.springmongodemo.service;


import org.globaltrainings.springmongodemo.dto.AddProduct;
import org.globaltrainings.springmongodemo.dto.ChangePriceRequestDto;
import org.globaltrainings.springmongodemo.dto.ProductDetails;
import org.globaltrainings.springmongodemo.document.Product;
import org.globaltrainings.springmongodemo.exceptions.InvalidArgumentException;
import org.globaltrainings.springmongodemo.exceptions.ProductNotFoundException;
import org.globaltrainings.springmongodemo.repository.IProductRepository;
import org.globaltrainings.springmongodemo.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepository repo;
    private ProductUtil util;

    private Random random=new Random();

    @Autowired
    public ProductServiceImpl(IProductRepository repo, ProductUtil util){
        this.repo =repo;
        this.util=util;
    }


    @Override
    public ProductDetails addProduct(AddProduct requestData) throws InvalidArgumentException {
        Product product = new Product();
        String id=newId();
<<<<<<< HEAD
        product.setId(id.trim());
        product.setName(requestData.getName());
=======
        product.setId(id);
        product.setName(requestData.getName().trim());
>>>>>>> 263d61c71d1f03d56c1bf5220e5036fa92de4475
        product.setPrice(requestData.getPrice());
        product=repo.save(product);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    @Override
    public ProductDetails findProductDetailsById(String id) throws InvalidArgumentException, ProductNotFoundException {
        Product product=findById(id.trim());
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    public Product findById(String id) throws InvalidArgumentException, ProductNotFoundException {
        Optional<Product> optional = repo.findById(id.trim());
        if(optional.isEmpty()){
            throw new ProductNotFoundException("product not found for id="+id);
        }
        Product product=optional.get();
        return product;
    }


    @Override
    public ProductDetails changePrice(ChangePriceRequestDto requestData) throws InvalidArgumentException, ProductNotFoundException {
        Product product=findById(requestData.getId().trim());
        product.setPrice(requestData.getNewPrice());
        product= repo.save(product);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    @Override
    public List<ProductDetails>fetchProductsOrderByPrice(){
      List<Product>products=  repo.findAll(Sort.by("price"));
      List<ProductDetails>desired=util.toProductDetailsList(products);
      return desired;
    }

    public String newId(){
        StringBuilder id=new StringBuilder();
        for (int i=0;i<6;i++){
           int randomNum =random.nextInt(99);
           id.append(randomNum);
        }
        return id.toString();
    }

}
