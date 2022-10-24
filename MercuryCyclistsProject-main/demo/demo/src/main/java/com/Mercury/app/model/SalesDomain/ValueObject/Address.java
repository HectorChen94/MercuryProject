package com.Mercury.app.model.SalesDomain.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class Address {

    private String address;

    public Address(){}

    public Address(String address){this.address = address;}

    public void setAddress(String address){this.address = address;}

    public String getAddress(){return this.address;}

    public int length() {
        return 0;
    }
}