package com.Mercury.app.model.SalesDomain.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class CustomerName {

    private String customerName;

    public CustomerName(){}

    public CustomerName(String customerName){this.customerName = customerName;}

    public void setManager(String customerName){this.customerName = customerName;}

    public String getCustomerName(String customerName){return this.customerName;}

    public int length() {
        return 0;
    }
}