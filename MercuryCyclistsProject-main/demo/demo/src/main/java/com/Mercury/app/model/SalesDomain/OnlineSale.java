package com.Mercury.app.model.SalesDomain;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class OnlineSale extends Sale
{
    private String customerName;
    private String customerAddress;

    public OnlineSale() {super();}

    @JsonCreator
    public OnlineSale(Long id, String productName, int quantity, LocalDateTime dataTime, String customerName, String customerAddress) {
        super(id, productName, quantity, dataTime);
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {return customerName;}
    public String getCustomerAddress() {return customerAddress;}

    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public void setCustomerAddress(String customerAddress) {this.customerAddress = customerAddress;}

    //This should call super.toString(), but this methods isn't really important though
    @Override
    public String toString() {
        return "OnlineSale{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}