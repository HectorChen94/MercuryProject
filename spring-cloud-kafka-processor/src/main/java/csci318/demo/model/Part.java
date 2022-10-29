package csci318.demo.model;

import javax.persistence.*;


@Entity
//@JsonDeserialize(as=Part.class)
public class Part
{
    @Id
    @GeneratedValue
    private Long partId;

    private String partName;

    private String description;
    private String productSales;

    public Part() {}

    public Part(String partName, Long partId, String description, String productSales){
         this.partName = partName;
        this.partId = partId;
        this.description = description;
        this.productSales = productSales;
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

    public String getProductSales() {
        return productSales;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }
    public void setPartId(Long partId) {
        this.partId = partId;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductSales(String productSales) {
        this.productSales = productSales;
    }

    @Override
    public String toString() {
        return "Part{" +
                "name='" + partName + '\'' +
                ", partId='" + partId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


