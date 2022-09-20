package com.Mercury.shareddomain;

/**
 * Event Data for the Cargo Booked Event
 */
public class ProductEventData {

    private Long productId;

    public ProductEventData(){}
    public ProductEventData(Long productId){
        this.productId = productId;

    }

    public void setProductId(Long productId){this.productId = productId;}
    public String getProductId(){return this.productId;}

}