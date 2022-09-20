package com.Mercury.app.model.ProcurementDomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String position;

    public Contact() {}

    public Contact(Long id, String name, String phone, String email, String position) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.position = position;
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public String getPhone() {return phone;}
    public String getEmail() {return email;}
    public String getPosition() {return position;}

    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setEmail(String email) {this.email = email;}
    public void setPosition(String position) {this.position = position;}
}
