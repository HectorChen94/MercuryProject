package com.Mercury.app.model.InventoryDomain.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class Description {

    private String description;

    public Description(){}

    public Description(String description){this.description = description;}

    public void setDescription(String description){this.description = description;}

    public String getDescription(){return this.description;}
}