package csci318.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product
{
    @Id
    @GeneratedValue
    private Long productId;
    @Embedded
    private String productName;

    private double price;
    @Embedded
    private String comment;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Part> parts;

    private int productSales;

    public Product() {}

    public Product(Long productId, String productName, double price, String comment, List<Part> parts, int productSales) {
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
    public List<Part> getParts() { return parts; }
    public int getProductSales() { return productSales; }

    public void setProductId(Long productId) { this.productId = productId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setComment(String comment) { this.comment = comment; }
    public void setPrice(double price) { this.price = price; }
    public void setParts(List<Part> parts) { this.parts = parts; }
    public void setProductSales(int productSales) { this.productSales = productSales; }

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