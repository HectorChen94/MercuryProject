package com.Mercury.app.model.InventoryDomain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@JsonDeserialize(as=Part.class)
public class Part implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Product product;

    public Part() {}

    public Part (String name, Long id, String description){
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public Part(Long id, String name, String description, Product product) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.product = product;
    }

    public String getName(){
        return name;
    }
    public Long getId(){
        return id;
    }
    public String getDescription(){
        return description;
    }

    public Product getProduct() { return product; }

    public void setName(String name) {
        this.name = name;
    }
    public void setPartId(Long partId) {
        this.id = partId;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setProduct(Product product) { this.product = product; }

    @Override
    public String toString() {
        return "Part{" +
                "name='" + name + '\'' +
                ", partId='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

    public Long getId(){
        return id;
    }
    public String getDescription(){
        return description;
    }

    public Product getProduct() { return product; }

    public void setName(String name) {
        this.name = name;
    }
    public void setPartId(Long partId) {
        this.id = partId;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setProduct(Product product) { this.product = product; }

    @Override
    public String toString() {
        return "Part{" +
                "name='" + name + '\'' +
                ", partId='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
