package org.globaltrainings.saleapp.productms.controllers;

import org.globaltrainings.saleapp.productms.dto.AddProduct;
import org.globaltrainings.saleapp.productms.dto.ChangePriceRequestDto;
import org.globaltrainings.saleapp.productms.dto.ProductDetails;
import org.globaltrainings.saleapp.productms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductRestController {

    private IProductService service;

    @Autowired
    public ProductRestController(IProductService service) {
        this.service = service;
    }



    //    /products/add
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add")
    public ProductDetails add(@RequestBody AddProduct requestData) throws Exception {
        ProductDetails response = service.addProduct(requestData);
        return response;
    }


    //     /products/byd/1
    // 200 ok
    @GetMapping("/byid/{id}")
    public ProductDetails fetchProductById(@PathVariable int id) throws Exception {
        ProductDetails response = service.findProductDetailsById(id);
        return response;
    }

    @GetMapping("/order/byprice")
    public List<ProductDetails> fetchAllByPrice() {
        List<ProductDetails> response = service.fetchProductsOrderByPrice();
        return response;
    }

    @PutMapping("/change/price")
    public ProductDetails changePrice(@RequestBody ChangePriceRequestDto requestData) throws Exception {
        ProductDetails response = service.changePrice(requestData);
        return response;
    }


}
