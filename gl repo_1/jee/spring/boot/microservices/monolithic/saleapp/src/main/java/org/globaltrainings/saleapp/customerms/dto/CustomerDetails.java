package org.globaltrainings.saleapp.customerms.dto;

import org.globaltrainings.saleapp.productms.dto.ProductDetails;
import org.globaltrainings.saleapp.productms.entity.Product;

import java.util.List;
import java.util.Objects;

/**
 * response dto
 */
public class CustomerDetails {

    private Long id;

    private String name;

    private List<ProductDetails>purchasedProducts;

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

    public List<ProductDetails> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<ProductDetails> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetails that = (CustomerDetails) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
