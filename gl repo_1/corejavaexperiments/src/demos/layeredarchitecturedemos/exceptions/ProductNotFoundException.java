package demos.layeredarchitecturedemos.exceptions;

import demos.layeredarchitecturedemos.entity.Product;

public class ProductNotFoundException extends Exception {


    public ProductNotFoundException(String msg) {
        super(msg);
    }


}
