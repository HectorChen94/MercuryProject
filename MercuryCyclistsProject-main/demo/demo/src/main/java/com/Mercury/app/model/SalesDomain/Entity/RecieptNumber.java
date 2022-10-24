package com.Mercury.app.model.SalesDomain.Entity;

import javax.persistence.Embeddable;


@Embeddable
public class RecieptNumber {

    private String recieptNumber;

    public RecieptNumber(){}

    public RecieptNumber(String recieptNumber){this.recieptNumber = recieptNumber;}

    public void setRecieptNumber(String recieptNumber){this.recieptNumber = recieptNumber;}

    public String getRecieptNumber(String recieptNumber){return this.recieptNumber;}

    public int length() {
        return 0;
    }
}
