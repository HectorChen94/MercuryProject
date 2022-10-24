package com.Mercury.app.model.SalesDomain.Aggregate;

import com.Mercury.app.model.InventoryDomain.ValueObject.ProductName;
import com.Mercury.app.model.SalesDomain.Entity.DataTime;
import com.Mercury.app.model.SalesDomain.Entity.RecieptNumber;
import com.Mercury.app.model.SalesDomain.ValueObject.Quantity;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class InStoreSale extends Sale
{
    private RecieptNumber recieptNumber;

    @ManyToOne
    private Store store;

    public InStoreSale() {super();}
    @JsonCreator
    public InStoreSale(Long id, ProductName productName, Quantity quantity, DataTime dataTime, RecieptNumber recieptNumber) {
        super(id, productName, quantity, dataTime);
        this.recieptNumber = recieptNumber;
        this.store = store;
    }

    public RecieptNumber getRecieptNumber() {return recieptNumber;}
    public Store getStore() { return store;}

    public void setRecieptNumber(RecieptNumber recieptNumber) {this.recieptNumber = recieptNumber;}

    //This should call super.toString(), but this methods isn't really important though
    @Override
    public String toString() {
        return "InStoreSale{" +
                "recieptNumber='" + recieptNumber + '\'' +
                '}';
    }
}
