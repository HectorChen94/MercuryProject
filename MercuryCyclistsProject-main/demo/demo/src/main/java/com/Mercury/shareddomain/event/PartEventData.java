package com.Mercury.shareddomain;

/**
 * Event Data for the Cargo Booked Event
 */
public class PartEventData {

    private Long partId;

    public PartEventData(){}
    public PartEventData(Long partId){
        this.partId = partId;

    }

    public void setPartId(Long partId){this.partId = partId;}
    public String getPartId(){return this.partId;}

}