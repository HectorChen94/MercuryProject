package com.Mercury.app.model.ProcurementDomain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Supplier
{
    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    private String base;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Contact> contacts;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Part> parts;

    public Supplier() {}

    public Supplier(Long id, String companyName, String base, List<Contact> contact) {
        this.id = id;
        this.companyName = companyName;
        this.base = base;
        this.contacts = contact;
    }

    public Supplier(Long id, String companyName, String base, List<Contact> contacts, List<Part> parts) {
        this.id = id;
        this.companyName = companyName;
        this.base = base;
        this.contacts = contacts;
        this.parts = parts;
    }

    public Long getId() {return id;}
    public String getCompanyName() {return companyName;}
    public String getBase() {return base;}
    public List<Contact> getContacts() {return contacts;}

    public List<Part> getParts() { return parts; }

    public void setId(Long id) {this.id = id;}
    public void setCompanyName(String companyName) {this.companyName = companyName;}
    public void setBase(String base) {this.base = base;}
    public void setContacts(List<Contact> contact) {this.contacts = contact;}
    public void setParts(List<Part> parts) { this.parts = parts; }
}

    public Long getId() {return id;}
    public String getCompanyName() {return companyName;}
    public String getBase() {return base;}
    public List<Contact> getContacts() {return contacts;}

    public List<Part> getParts() { return parts; }

    public void setId(Long id) {this.id = id;}
    public void setCompanyName(String companyName) {this.companyName = companyName;}
    public void setBase(String base) {this.base = base;}
    public void setContacts(List<Contact> contact) {this.contacts = contact;}
    public void setParts(List<Part> parts) { this.parts = parts; }
}
