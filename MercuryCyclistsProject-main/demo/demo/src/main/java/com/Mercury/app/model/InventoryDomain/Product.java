package com.Mercury.app.model.InventoryDomain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private String comment;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Part> parts;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Sale> sales;

    public Product() {}

    public Product(Long id, String name, double price, String comment) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.comment = comment;
    }

    public Product(Long id, String name, double price, String comment, List<Part> parts) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.comment = comment;
        this.parts = parts;
    }

    public Product(Long id, String name, double price, String comment, List<Part> parts, List<Sale> sales) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.comment = comment;
        this.parts = parts;
        this.sales = sales;
    }

    public Long getId() {return id;}
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getComment() { return comment; }

    public List<Part> getParts() { return parts; }

    public List<Sale> getSales() { return sales; }

    public void setProductId(Long productId) { this.id = productId; }
    public void setName(String name) { this.name = name; }
    public void setComment(String comment) { this.comment = comment; }
    public void setPrice(double price) { this.price = price; }

    public void setParts(List<Part> parts) { this.parts = parts; }

    public void setSales(List<Sale> sales) { this.sales = sales; }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productId=" + id +
                ", price='" + price + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
