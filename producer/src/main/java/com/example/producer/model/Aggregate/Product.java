package com.example.producer.model.Aggregate;

import com.example.producer.model.ValueObject.Comment;
import com.example.producer.model.ValueObject.Price;
import com.example.producer.model.ValueObject.ProductName;


import javax.persistence.*;
import java.util.List;

@Entity
public class Product
{
    @Id
    @GeneratedValue
    private Long productId;
    @Embedded
    private ProductName productName;
    @Embedded
    private Price price;
    @Embedded
    private Comment comment;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Part> parts;



    public Product() {}

    public Product(Long productId, ProductName productName, Price price, Comment comment) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.comment = comment;
    }

    public Product(Long productId, ProductName productName, Price price, Comment comment, List<Part> parts) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.comment = comment;
        this.parts = parts;
    }

    public Long getProductId() {return productId;}
    public ProductName getProductName() { return productName; }
    public Price getPrice() { return price; }
    public Comment getComment() { return comment; }

    public List<Part> getParts() { return parts; }

    public void setProductId(Long productId) { this.productId = productId; }
    public void setProductName(ProductName productName) { this.productName = productName; }
    public void setComment(Comment comment) { this.comment = comment; }
    public void setPrice(Price price) { this.price = price; }

    public void setParts(List<Part> parts) { this.parts = parts; }


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
