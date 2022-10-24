package com.Mercury.app.model.SalesDomain.Aggregate;

import com.Mercury.app.model.InventoryDomain.ValueObject.ProductName;
import com.Mercury.app.model.SalesDomain.Entity.DataTime;
import com.Mercury.app.model.SalesDomain.ValueObject.CustomerAddress;
import com.Mercury.app.model.SalesDomain.ValueObject.CustomerName;
import com.Mercury.app.model.SalesDomain.ValueObject.Quantity;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class OnlineSale extends Sale
{
    @Embedded
    private CustomerName customerName;
    @Embedded
    private CustomerAddress customerAddress;

    public OnlineSale() {super();}

    @JsonCreator
    public OnlineSale(Long id, ProductName productName, Quantity quantity, DataTime dataTime, CustomerName customerName, CustomerAddress customerAddress) {
        super(id, productName, quantity, dataTime);
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public CustomerName getCustomerName() {return customerName;}
    public CustomerAddress getCustomerAddress() {return customerAddress;}

    public void setCustomerName(CustomerName customerName) {this.customerName = customerName;}
    public void setCustomerAddress(CustomerAddress customerAddress) {this.customerAddress = customerAddress;}

    //This should call super.toString(), but this methods isn't really important though
    @Override
    public String toString() {
        return "OnlineSale{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
