package com.example.demo.shareddomain.event;

public class ProductEvent {

    ProductEventData productEventData;
    public ProductEvent(){}
    public ProductEvent(ProductEventData productEventData){
        this.productEventData = productEventData;
    }

    public void setProductEventData(ProductEventData productEventData){this.productEventData = productEventData;}
    public ProductEventData getProductEventData(){
        return productEventData;
    }
}