package org.globaltrainings.saleapp.customerms.dto;

import javax.validation.constraints.Min;

/**
 * request dto
 */
public class BuyProductRequest {
    @Min(1)
    private int productId;
   @Min(1)
    private long customerId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int  productId) {
        this.productId = productId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
