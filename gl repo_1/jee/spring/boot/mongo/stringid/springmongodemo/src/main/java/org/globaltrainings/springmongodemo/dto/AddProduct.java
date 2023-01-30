package org.globaltrainings.springmongodemo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Add product Request Data Transfer Object
 */
public class AddProduct {

    @Length(min = 2,max=20,message = "name shuld between 2 and 20")
    @NotBlank(message = "name can't be blank or empty")
    private String name;

    @Min(0)
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
