package demos.exceptiondemos;

import java.util.List;

public class StoreFrontend {
    public static void main(String args[]) {
        StoreFrontend frontend = new StoreFrontend();
        ProductStore store = new ProductStore();
        try {
            //shop owners
            store.addProduct("samsung", 20000);
            store.addProduct("motorola", 15000);
            store.addProduct(null, -100000);
        } catch (InvalidArgumentException e) {
            System.out.println("invalig input " + e.getMessage());
        }

        // customers
        List<Product> list = store.getProducts();
        for (Product product : list) {
            frontend.display(product);
        }

    }

    void display(Product product) {
        System.out.println("name=" + product.getName() + ", price=" + product.getPrice());
    }

}
