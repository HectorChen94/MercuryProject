package com.example.demo.shareddomain.event;

/**
 * Event Data for the Part Event
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