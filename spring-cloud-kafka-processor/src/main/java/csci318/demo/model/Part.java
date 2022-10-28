package csci318.demo.model;

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
    private String partName;
    @Embedded
    private String description;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Product product;

    public Part() {}

    public Part(String partName, Long partId, String description){
        this.partName = partName;
        this.partId = partId;
        this.description = description;
    }

    public Part(Long partId, String partName, String description, Product product) {
        this.partId = partId;
        this.partName = partName;
        this.description = description;
        this.product = product;
    }

    public String getPartName(){
        return partName;
    }
    public Long getPartId(){
        return partId;
    }

    public String getDescription(){
        return description;
    }

    public Product getProduct() { return product; }


    public void setPartName(String partName) {
        this.partName = partName;
    }
    public void setPartId(Long partId) {
        this.partId = partId;
    }
    public void setDescription(String description) {
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
