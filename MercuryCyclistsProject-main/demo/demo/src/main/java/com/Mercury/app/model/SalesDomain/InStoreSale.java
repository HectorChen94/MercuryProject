package com.Mercury.app.model.SalesDomain;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class InStoreSale extends Sale
{
    private String recieptNumber;

    @ManyToOne
    private Store store;

    public InStoreSale() {super();}
    @JsonCreator
    public InStoreSale(Long id, String productName, int quantity, LocalDateTime dataTime, String recieptNumber) {
        super(id, productName, quantity, dataTime);
        this.recieptNumber = recieptNumber;
        this.store = store;
    }

    public String getRecieptNumber() {return recieptNumber;}
    public Store getStore() { return store;}

    public void setRecieptNumber(String recieptNumber) {this.recieptNumber = recieptNumber;}

    //This should call super.toString(), but this methods isn't really important though
    @Override
    public String toString() {
        return "InStoreSale{" +
                "recieptNumber='" + recieptNumber + '\'' +
                '}';
    }
}
