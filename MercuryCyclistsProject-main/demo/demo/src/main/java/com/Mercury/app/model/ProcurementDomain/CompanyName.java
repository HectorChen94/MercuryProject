package com.Mercury.app.model.ProcurementDomain;

import javax.persistence.Embeddable;

@Embeddable
public class CompanyName
{
    public String name;
    public CompanyName() {}
    public CompanyName(String name) {this.name = name;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
