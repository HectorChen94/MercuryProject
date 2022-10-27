package csci318.demo.model;

public class ProductSales
{
    private String productName;
    private long salesQuantity; //How many sales the associated product has

    public ProductSales() {}
    public ProductSales(String productName, long salesQuantity) {
        this.productName = productName;
        this.salesQuantity = salesQuantity;
    }

    public String getProductName() {return productName;}
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public long getSalesQuantity() {
        return salesQuantity;
    }
    public void setSalesQuantity(long salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    @Override
    public String toString() {
        return "ProductSales{" +
                "productName='" + productName + '\'' +
                ", salesQuantity=" + salesQuantity +
                '}';
    }
}
