package com.Mercury.app.model.InventoryDomain.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class Price {

    private Double price;

    public Price(){}

    public Price(Double price){this.price = price;}

    public void setPrice(Double price){this.price = price;}

    public Double getPrice(){return this.price;}
}
