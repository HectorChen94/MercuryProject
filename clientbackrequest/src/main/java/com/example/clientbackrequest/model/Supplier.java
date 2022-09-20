package com.example.clientbackrequest.model;

import javax.persistence.*;

public class Supplier {
    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    private String base;

    public Supplier() {
    }

    public Supplier(Long id, String companyName, String base) {
        this.id = id;
        this.companyName = companyName;
        this.base = base;

    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getBase() {
        return base;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
