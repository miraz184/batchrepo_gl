package demos.passbydemos;

public class PassByDemo2 {
    public static void main(String args[]){
        PassByDemo2 demo=new PassByDemo2();
        Product product=new Product(1,"samsung");
        demo.change(product);
        System.out.println("inside main,product"+product.getId()+"-"+product.getName());
    }

    void change(Product productCopy){
        productCopy=new Product(2,"motorola");
        System.out.println("inside change product="+productCopy.getId()+"-"+productCopy.getName());
    }
}
