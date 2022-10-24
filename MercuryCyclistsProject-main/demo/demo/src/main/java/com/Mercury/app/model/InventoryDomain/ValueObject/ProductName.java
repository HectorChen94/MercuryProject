package com.Mercury.app.model.InventoryDomain.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class ProductName {

    private String productName;

    public ProductName(){}

    public ProductName(String productName){this.productName = productName;}

    public void setProductName(String productName){this.productName = productName;}

    public String getProductName(){return this.productName;}

    public int length() {
        return 0;
    }
}