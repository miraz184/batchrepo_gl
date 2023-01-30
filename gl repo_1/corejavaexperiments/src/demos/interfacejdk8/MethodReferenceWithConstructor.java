package demos.interfacejdk8;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class MethodReferenceWithConstructor {

    public static void main(String args[]) {
        Supplier<Product> supplier = Product::new;
        Product product1 = supplier.get();
        product1.setId(1);
        product1.setName("samsung");
        System.out.println("product=" + product1.getId() + "-" + product1.getName());

        BiFunction<Integer, String, Product> productInstanceFetcher = Product::new;
        Product product2 = productInstanceFetcher.apply(10, "moto");
        System.out.println("product2=" + product2.getId() + "-" + product2.getName());


        Supplier<ArrayList> listSupplier = ArrayList::new;
        ArrayList<String> list = listSupplier.get();
        list.add("good");
        list.add("bye");
        System.out.println("list="+list);

    }
}
