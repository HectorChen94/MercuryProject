package com.example.producer.model.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class PartName {

    private String partName;

    public PartName(){}

    public PartName(String partName){this.partName = partName;}

    public void setPartName(String partName){this.partName = partName;}

    public String getPartName(){return this.partName;}

    public int length() {
        return 0;
    }
}