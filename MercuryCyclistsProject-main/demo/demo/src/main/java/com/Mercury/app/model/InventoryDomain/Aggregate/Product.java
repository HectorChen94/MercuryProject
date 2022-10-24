package com.Mercury.app.model.InventoryDomain.Aggregate;

import com.Mercury.app.model.InventoryDomain.ValueObject.Comment;
import com.Mercury.app.model.InventoryDomain.ValueObject.Price;
import com.Mercury.app.model.InventoryDomain.ValueObject.ProductName;
import com.Mercury.app.model.SalesDomain.Aggregate.Sale;

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

    @OneToMany(cascade=CascadeType.ALL)
    private List<Sale> sales;

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

    public Product(Long productId, ProductName productName, Price price, Comment comment, List<Part> parts, List<Sale> sales) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.comment = comment;
        this.parts = parts;
        this.sales = sales;
    }

    public Long getProductId() {return productId;}
    public ProductName getProductName() { return productName; }
    public Price getPrice() { return price; }
    public Comment getComment() { return comment; }

    public List<Part> getParts() { return parts; }

    public List<Sale> getSales() { return sales; }

    public void setProductId(Long productId) { this.productId = productId; }
    public void setProductName(ProductName productName) { this.productName = productName; }
    public void setComment(Comment comment) { this.comment = comment; }
    public void setPrice(Price price) { this.price = price; }

    public void setParts(List<Part> parts) { this.parts = parts; }

    public void setSales(List<Sale> sales) { this.sales = sales; }

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
