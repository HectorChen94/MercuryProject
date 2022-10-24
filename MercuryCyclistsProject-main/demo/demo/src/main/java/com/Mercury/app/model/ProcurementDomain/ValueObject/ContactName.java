package com.Mercury.app.model.ProcurementDomain;

import javax.persistence.Embeddable;

@Embeddable
public class ContactName
{
    public String name;

    public ContactName() {}
    public ContactName(String name) {this.name = name;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
