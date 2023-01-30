package org.globaltrainings.saleapp.productms.entity;

import javax.persistence.*;
import java.util.Objects;


@Table(name = "products_data")
@Entity
public class Product {

    @GeneratedValue
    @Id
    private Integer id;
    private String name;

    @Column(name="product_price")
    private double price;

    public Product() {
    }

    public Product( String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
