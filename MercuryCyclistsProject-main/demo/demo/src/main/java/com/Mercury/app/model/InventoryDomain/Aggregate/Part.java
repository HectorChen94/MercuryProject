package com.Mercury.app.model.InventoryDomain.Aggregate;

import com.Mercury.app.model.InventoryDomain.ValueObject.Description;
import com.Mercury.app.model.InventoryDomain.ValueObject.PartName;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@JsonDeserialize(as=Part.class)
public class Part implements Serializable
{
    @Id
    @GeneratedValue
    private Long partId;
    @Embedded
    private PartName partName;
    @Embedded
    private Description description;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Product product;

    public Part() {}

    public Part (PartName partName, Long partId, Description description){
        this.partName = partName;
        this.partId = partId;
        this.description = description;
    }

    public Part(Long partId, PartName partName, Description description, Product product) {
        this.partId = partId;
        this.partName = partName;
        this.description = description;
        this.product = product;
    }

    public PartName getPartName(){
        return partName;
    }
    public Long getPartId(){
        return partId;
    }

    public Description getDescription(){
        return description;
    }

    public Product getProduct() { return product; }


    public void setPartName(PartName partName) {
        this.partName = partName;
    }
    public void setPartId(Long partId) {
        this.partId = partId;
    }
    public void setDescription(Description description) {
        this.description = description;
    }

    public void setProduct(Product product) { this.product = product; }

    @Override
    public String toString() {
        return "Part{" +
                "name='" + partName + '\'' +
                ", partId='" + partId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

