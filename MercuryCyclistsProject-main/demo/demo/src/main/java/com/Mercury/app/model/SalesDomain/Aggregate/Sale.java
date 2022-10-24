package com.Mercury.app.model.SalesDomain.Aggregate;

import com.Mercury.app.model.InventoryDomain.Aggregate.Product;
import com.Mercury.app.model.InventoryDomain.ValueObject.ProductName;
import com.Mercury.app.model.SalesDomain.Entity.DataTime;
import com.Mercury.app.model.SalesDomain.ValueObject.Quantity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
    @Embedded
    private ProductName productName;
    @Embedded
    private Quantity quantity;
    @Embedded
    private DataTime dataTime;
    @ManyToOne
    private Product product;

    public Sale() {}

    public Sale(Long id, ProductName productName, Quantity quantity, DataTime dataTime) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.dataTime = dataTime;
    }

    public Sale(Long id, ProductName productName, Quantity quantity, DataTime dataTime, Product product) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.dataTime = dataTime;
        this.product = product;
    }

    public Long getId() {return id;}
    public ProductName getProductName() {return productName;}
    public Quantity getQuantity() {return quantity;}
    public DataTime getDataTime() {return dataTime;}
    public Product getProduct() { return product; }

    public void setId(Long id) {this.id = id;}
    public void setProductName(ProductName productName) {this.productName = productName;}
    public void setQuantity(Quantity quantity) {this.quantity = quantity;}
    public void setDataTime(DataTime dataTime) {this.dataTime = dataTime;}
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
