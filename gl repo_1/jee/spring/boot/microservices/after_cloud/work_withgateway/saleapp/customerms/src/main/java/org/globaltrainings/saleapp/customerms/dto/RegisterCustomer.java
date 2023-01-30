package org.globaltrainings.saleapp.customerms.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * request dto
 */
public class RegisterCustomer {
    @Length(min = 2, max=20)
    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
