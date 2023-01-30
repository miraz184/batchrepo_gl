package demos.layeredarchitecturedemos.frontend;

import demos.layeredarchitecturedemos.entity.Product;
import demos.layeredarchitecturedemos.exceptions.InvalidArgumentException;
import demos.layeredarchitecturedemos.exceptions.ProductNotFoundException;
import demos.layeredarchitecturedemos.service.IProductService;
import demos.layeredarchitecturedemos.service.ProductServiceImpl;

public class FrontEnd {
    private IProductService service=new ProductServiceImpl();

    public void runUI(){
        try {
            Product product1 = service.addProduct("samsung", 20000);
            System.out.println("**added product");
            display(product1);
            Product product2 = service.addProduct("moto", 30000);
            System.out.println("***added product");
            display(product2);
            int id=product1.getId();
            Product found=service.findById(id);
            System.out.println("***fetched product");
            display(found);
            System.out.println("**change price");
            Product changed=service.changePrice(id,40000);
            display(changed);


        }catch (InvalidArgumentException e){
            System.out.println("inputs you entered are invalid,"+e.getMessage());
        }
        catch (ProductNotFoundException e){
            System.out.println("product not found for id you provided,"+e.getMessage());
        }
        catch (Exception e){
            System.out.println("something went wrong, Please try again");
        }
    }


    void display(Product product){
        System.out.println("id="+product.getId()+",name="+product.getName()+",price="+product.getPrice());
    }

}
