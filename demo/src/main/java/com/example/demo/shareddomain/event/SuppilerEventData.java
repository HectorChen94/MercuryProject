package com.example.demo.shareddomain.event;

/**
 * Event Data for the Cargo Booked Event
 */
public class SupplierEventData {

    private Long id;

    public SupplierEventData(){}
    public SupplierEventData(Long id){
        this.id = id;

    }

    public void setSupplierId(Long id){this.id = id;}
    public String getSupplierId(){return this.id;}

}