package com.Mercury.app.model.ProcurementDomain;

import com.Mercury.app.model.InventoryDomain.Part;

import javax.persistence.*;
import java.util.List;

@Entity
public class Supplier
{
    @Id
    @GeneratedValue
    private Long id;
    private CompanyName companyName;
    private Base base;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Contact> contacts;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Part> parts;

    public Supplier() {}

    public Supplier(Long id, CompanyName companyName, Base base, List<Contact> contact) {
        this.id = id;
        this.companyName = companyName;
        this.base = base;
        this.contacts = contact;
    }

    public Supplier(Long id, CompanyName companyName, Base base, List<Contact> contacts, List<Part> parts) {
        this.id = id;
        this.companyName = companyName;
        this.base = base;
        this.contacts = contacts;
        this.parts = parts;
    }

    public Long getId() {return id;}
    public CompanyName getCompanyName() {return companyName;}
    public Base getBase() {return base;}
    public List<Contact> getContacts() {return contacts;}

    public List<Part> getParts() { return parts; }

    public void setId(Long id) {this.id = id;}
    public void setCompanyName(CompanyName companyName) {this.companyName = companyName;}
    public void setBase(Base base) {this.base = base;}
    public void setContacts(List<Contact> contact) {this.contacts = contact;}
    public void setParts(List<Part> parts) { this.parts = parts; }
}
