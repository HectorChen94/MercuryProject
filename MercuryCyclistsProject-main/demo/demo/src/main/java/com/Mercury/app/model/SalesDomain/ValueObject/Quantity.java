package com.Mercury.app.model.SalesDomain.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class Quantity {

    private int quantity;

    public Quantity(){}

    public Quantity(int quantity){this.quantity = quantity;}

    public void setQuantity(int quantity){this.quantity = quantity;}

    public int getQuantity(){return this.quantity;}

    public int length() {
        return 0;
    }
}
