package com.example.demo;


import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateExperiments {

    private String baseProductUrl="http://localhost:8585/products";

    private RestTemplate restTemplate;

    private RestTemplateExperiments(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public void fireRequests(){
        AddProductRequestDTO requestData1=new AddProductRequestDTO("samsung",20000);
        ProductDetailsResponseDTO response1=addProduct1(requestData1);
        display(response1);
        AddProductRequestDTO requestData2=new AddProductRequestDTO("moto",15000);
        ProductDetailsResponseDTO response2=addProduct2(requestData2);
        display(response2);
        AddProductRequestDTO requestData3=new AddProductRequestDTO("iphone",80000);
        ProductDetailsResponseDTO response3=addProduct3(requestData3);
        display(response3);

        ProductDetailsResponseDTO response4=changePrice(response1.getId(), 30000);
        display(response4);

        int id1=response1.getId();
        int id2=response2.getId();
        ProductDetailsResponseDTO response5=fetchProductsById1(id1);
        display(response5);
        ProductDetailsResponseDTO response6=fetchProductsById2(id2);
        display(response6);
    }

    public void display(ProductDetailsResponseDTO product){
        System.out.println("product id="+product.getId()+",name="+product.getName()+",price="+product.getPrice());
    }


    public ProductDetailsResponseDTO fetchProductsById1(int id){
        System.out.println("***inside fetchProductsById1(*) id="+id);
        String url=baseProductUrl+"/byid/"+id;
        ProductDetailsResponseDTO response=restTemplate.getForObject(url, ProductDetailsResponseDTO.class);
        return response;
    }


    public ProductDetailsResponseDTO fetchProductsById2(int id){
        System.out.println("***inside  fetchProductsById2(*), id="+id);
        String url=baseProductUrl+"/byid/"+id;
        ResponseEntity<ProductDetailsResponseDTO> responseEntity=restTemplate.getForEntity(url, ProductDetailsResponseDTO.class);
        ProductDetailsResponseDTO responseData=responseEntity.getBody();
        HttpStatus status=responseEntity.getStatusCode();
        System.out.println("resposne status code="+status.value()+" "+status.name());
        HttpHeaders headers=responseEntity.getHeaders();
        System.out.println("headers received in resposne, content type="+headers);
        return responseData;
    }

    public ProductDetailsResponseDTO addProduct1(AddProductRequestDTO requestData){
        System.out.println("***inside addProduct1(*)");
        String url=baseProductUrl+"/add";
        ProductDetailsResponseDTO response=restTemplate.postForObject(url,requestData,ProductDetailsResponseDTO.class);
        return response;
    }

    public ProductDetailsResponseDTO addProduct2(AddProductRequestDTO requestData){
        System.out.println("***inside addProduct2(*)");
        String url=baseProductUrl+"/add";
        ResponseEntity<ProductDetailsResponseDTO> responseEntity=restTemplate.postForEntity(url,requestData,ProductDetailsResponseDTO.class);
        ProductDetailsResponseDTO responseData=responseEntity.getBody();
        HttpStatus status=responseEntity.getStatusCode();
        System.out.println("resposne status code="+status.value()+" "+status.name());
        HttpHeaders headers=responseEntity.getHeaders();
        System.out.println("headers received in resposne, content type="+headers);
        return responseData;
    }

    public ProductDetailsResponseDTO addProduct3(AddProductRequestDTO requestData){
        System.out.println("***inside addProduct3(*)");
        String url=baseProductUrl+"/add";
        HttpEntity<AddProductRequestDTO>requestEntity=new HttpEntity<>(requestData);
        ResponseEntity<ProductDetailsResponseDTO> responseEntity=restTemplate.exchange(url, HttpMethod.POST,requestEntity,ProductDetailsResponseDTO.class);
        ProductDetailsResponseDTO responseData=responseEntity.getBody();
        HttpStatus status=responseEntity.getStatusCode();
        System.out.println("resposne status code="+status.value()+" "+status.name());
        HttpHeaders headers=responseEntity.getHeaders();
        System.out.println("headers received in resposne, content type="+headers);
        return responseData;
    }

    public ProductDetailsResponseDTO changePrice(int productId, double newPrice){
        System.out.println("***inside  changePrice(*) productId="+productId+"new price="+newPrice);
        String url=baseProductUrl+"/change/price";
        ChangePriceRequestDTO requestDTO=new ChangePriceRequestDTO();
        requestDTO.setId(productId);
        requestDTO.setNewPrice(newPrice);
        HttpEntity<ChangePriceRequestDTO>requestEntity=new HttpEntity<>(requestDTO);
        ResponseEntity<ProductDetailsResponseDTO> responseEntity=restTemplate.exchange(url, HttpMethod.PUT,requestEntity,ProductDetailsResponseDTO.class);
        ProductDetailsResponseDTO responseData=responseEntity.getBody();
        HttpStatus status=responseEntity.getStatusCode();
        System.out.println("resposne status code="+status.value()+" "+status.name());
        HttpHeaders headers=responseEntity.getHeaders();
        System.out.println("headers received in resposne, content type="+headers);
        return responseData;
    }



}
