package org.gltrainings.saleapp.frontend.model;

public class ChangePriceRequestDto {

    private int id;
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
