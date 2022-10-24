package com.Mercury.app.model.SalesDomain.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class Manager {

    private String manager;

    public Manager(){}

    public Manager(String manager){this.manager = manager;}

    public void setManager(String manager){this.manager = manager;}

    public String getManager(){return this.manager;}

    public int length() {
        return 0;
    }
}
