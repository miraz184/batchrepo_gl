package demos.exceptiondemos;

import java.util.*;

public class ProductStore {
    private Map<Integer, Product> db = new HashMap<>();

    private int generatedId;

    private int generateId() {
        return ++generatedId;
    }


    void addProduct(String name, double price)throws InvalidArgumentException{
        if(name==null||name.isEmpty()){
            throw new InvalidArgumentException("name is null or empty");
        }
        if(price<0){
            throw new InvalidArgumentException("price can't b esmaller than zero");
        }

        int newId = generateId();
        System.out.println("line after lowercase");
        Product product = new Product(newId, name, price);
        db.put(newId, product);

    }

    public List<Product> getProducts() {
        Collection<Product> products = db.values();
        List<Product> productList = new ArrayList<>();
        productList.addAll(products);
        return productList;
    }


}
