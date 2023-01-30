package org.gltrainings.saleapp.frontend.model;

/**
 * Add product Request Data Transfer Object
 */
public class AddProduct {

    private String name;

   private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
