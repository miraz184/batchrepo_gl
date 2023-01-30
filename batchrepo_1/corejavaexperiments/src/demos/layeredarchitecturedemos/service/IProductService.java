package demos.layeredarchitecturedemos.service;

import demos.layeredarchitecturedemos.entity.Product;
import demos.layeredarchitecturedemos.exceptions.InvalidArgumentException;
import demos.layeredarchitecturedemos.exceptions.ProductNotFoundException;

public interface IProductService {

    Product addProduct(String name, double price) throws InvalidArgumentException;

    Product findById(int id) throws InvalidArgumentException, ProductNotFoundException;

    Product changePrice(int id, double newPrice) throws InvalidArgumentException,  ProductNotFoundException;


}
