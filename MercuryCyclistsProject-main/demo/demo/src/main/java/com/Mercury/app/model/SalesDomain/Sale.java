package com.Mercury.app.model.SalesDomain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance
//@JsonDeserialize(as=OnlineSale.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(
        {@JsonSubTypes.Type(value = InStoreSale.class),
                @JsonSubTypes.Type(value = OnlineSale.class)   }
)
public abstract class Sale
{
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private int quantity;
    private LocalDateTime dataTime;
    @ManyToOne
    private Product product;

    public Sale() {}

    public Sale(Long id, String productName, int quantity, LocalDateTime dataTime) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.dataTime = dataTime;
    }

    public Sale(Long id, String productName, int quantity, LocalDateTime dataTime, Product product) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.dataTime = dataTime;
        this.product = product;
    }

    public Long getId() {return id;}
    public String getProductName() {return productName;}
    public int getQuantity() {return quantity;}
    public LocalDateTime getDataTime() {return dataTime;}
    public Product getProduct() { return product; }

    public void setId(Long id) {this.id = id;}
    public void setProductName(String productName) {this.productName = productName;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setDataTime(LocalDateTime dataTime) {this.dataTime = dataTime;}
    public void setProduct(Product product) { this.product = product; }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", dataTime=" + dataTime +
                '}';
    }
}
