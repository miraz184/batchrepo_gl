package demos.passbydemos;

public class PassByDemo3 {
    public static void main(String args[]){
        PassByDemo3 demo=new PassByDemo3();
        Product product=new Product(1,"samsung");
        demo.change(product);
        System.out.println("inside main,product"+product.getId()+"-"+product.getName());
    }

    void change(Product productCopy){
        productCopy.setName("mototorola");
        System.out.println("inside change product="+productCopy.getId()+"-"+productCopy.getName());
    }
}
