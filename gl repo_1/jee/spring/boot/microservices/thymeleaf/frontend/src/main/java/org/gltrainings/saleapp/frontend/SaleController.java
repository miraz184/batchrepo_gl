package org.gltrainings.saleapp.frontend;

import org.gltrainings.saleapp.frontend.model.ProductDetails;
import org.gltrainings.saleapp.frontend.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SaleController {


    @Autowired
    private RequestUtil requestUtil;

    @GetMapping("/listproducts")
    public ModelAndView listProducts(){
        List<ProductDetails> products=requestUtil.fetchAllProductsByPrice();
        ModelAndView modelAndView=new ModelAndView("productslist","products",products);
        return modelAndView;
    }


   @GetMapping("/greet")
    public ModelAndView greet(){
       String msg="Welcome to thymeleaf template ";

        ModelAndView modelAndView=new ModelAndView("welcome","msg",msg);
        return modelAndView;
    }

}
