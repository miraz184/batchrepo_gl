package org.globaltrainings.springjpademo.frontend;

import org.globaltrainings.springjpademo.entity.Product;
import org.globaltrainings.springjpademo.exceptions.InvalidArgumentException;
import org.globaltrainings.springjpademo.exceptions.ProductNotFoundException;
import org.globaltrainings.springjpademo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FrontEnd {
    private IProductService service;

    @Autowired
    public FrontEnd(IProductService service){
     this.service=service;
    }


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

            System.out.println("list products order by price");
            List<Product> list=service.fetchProductsOrderByPrice();
            list.stream().forEach(this::display);


        }catch (InvalidArgumentException e){
            System.out.println("inputs you entered are invalid,"+e.getMessage());
        }
        catch (ProductNotFoundException e){
            System.out.println("product not found for id you provided,"+e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("something went wrong, Please try again");
        }
    }


    void display(Product product){
        System.out.println("id="+product.getId()+",name="+product.getName()+",price="+product.getPrice());
    }

}
