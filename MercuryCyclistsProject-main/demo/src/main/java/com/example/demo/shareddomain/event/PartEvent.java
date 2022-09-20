package com.example.demo.shareddomain.event;

public class PartEvent {

    PartEventData partEventData;
    public PartEvent(){}
    public PartEvent(PartEventData partEventData){
        this.partEventData = partEventData;
    }

    public void setPartEventData(PartEventData partEventData){this.partEventData = partEventData;}
    public PartEventData getPartEventData(){
        return partEventData;
    }
}