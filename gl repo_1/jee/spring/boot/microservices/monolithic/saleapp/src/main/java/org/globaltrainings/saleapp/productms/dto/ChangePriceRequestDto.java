package org.globaltrainings.saleapp.productms.dto;

import javax.validation.constraints.Min;

public class ChangePriceRequestDto {
    @Min(1)
    private int id;
    @Min(0)
    private double newPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
}
