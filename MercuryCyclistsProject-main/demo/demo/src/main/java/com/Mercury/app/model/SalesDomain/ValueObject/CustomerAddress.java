package com.Mercury.app.model.SalesDomain.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class CustomerAddress {

    private String customerAddress;

    public CustomerAddress(){}

    public CustomerAddress(String customerAddress){this.customerAddress = customerAddress;}

    public void setManager(String customerAddress){this.customerAddress = customerAddress;}

    public String getCustomerAddress(String customerAddress){return this.customerAddress;}

    public int length() {
        return 0;
    }
}