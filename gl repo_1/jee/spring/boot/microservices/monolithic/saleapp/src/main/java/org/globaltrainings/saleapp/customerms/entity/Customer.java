package org.globaltrainings.saleapp.customerms.entity;

import org.globaltrainings.saleapp.productms.entity.Product;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Table(name = "customers_data")
@Entity
public class Customer {

    @GeneratedValue
    @Id
    private Long id;


    private String name;

    @JoinTable(name="customers_products",joinColumns = @JoinColumn(name="customer_id"),
    inverseJoinColumns = @JoinColumn(name="product_id"))
    @ManyToMany
    private Set<Product> purchasedProducts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(Set<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
