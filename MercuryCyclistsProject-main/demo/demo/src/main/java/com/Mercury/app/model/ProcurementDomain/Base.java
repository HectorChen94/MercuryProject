package com.Mercury.app.model.ProcurementDomain;

import javax.persistence.Embeddable;

@Embeddable
public class Base
{
    public String base;

    public Base() {}
    public Base(String base) {this.base = base;}
    public String getBase() {return base;}
    public void setBase(String base) {this.base = base;}
}
