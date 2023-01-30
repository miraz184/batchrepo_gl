package demos.interfacejdk8;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String args[]){

        IGreet greet1=()->"Welcome1";
        String msg1=greet1.message();
        System.out.println("message1="+msg1);

        Supplier<String>greet2=()->"Welcome2";
        String msg2=greet2.get();
        System.out.println("message2="+msg2);


        INewProduct productInstanceCreator1=()->new Product();
        Product product1=productInstanceCreator1.newInstance();

        Supplier<Product>productInstanceCreator2=()->new Product();
        Product product2=productInstanceCreator2.get();




    }
}
