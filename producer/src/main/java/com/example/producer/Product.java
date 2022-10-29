package com.example.producer.model;

import javax.persistence.*;

@Entity
public class Product
{
    @Id
    @GeneratedValue
    private Long productId;

    private String productName;

    private double price;

    private String comment;


    private String parts;

    private String productSales;

    public Product() {}

    public Product(Long productId, String productName, double price, String comment, String parts, String productSales) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.comment = comment;
        this.parts = parts;
        this.productSales = productSales;
    }

    public Long getProductId() {return productId;}
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getComment() { return comment; }
    public String getParts() { return parts; }
    public String getProductSales() { return productSales; }

    public void setProductId(Long productId) { this.productId = productId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setComment(String comment) { this.comment = comment; }
    public void setPrice(double price) { this.price = price; }
    public void setParts(String parts) { this.parts = parts; }
    public void setProductSales(String productSales) { this.productSales = productSales; }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + productName + '\'' +
                ", productId=" + productId +
                ", price='" + price + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
