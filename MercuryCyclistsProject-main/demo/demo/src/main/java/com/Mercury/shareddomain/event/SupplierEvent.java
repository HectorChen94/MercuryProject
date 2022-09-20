package com.Mercury.shareddomain;

public class SupplierEvent {

    SupplierEventData supplierEventData;
    public SupplierEvent(){}
    public SupplierEvent(SupplierEventData supplierEventData){
        this.supplierEventData = supplierEventData;
    }

    public void setSupplierEventData(SupplierEventData supplierEventData){this.supplierEventData = supplierEventData;}
    public SupplierEventData getSupplierEventData(){
        return supplierEventData;
    }
}