package csci318.demo.model;

public class ProductSalesValue
{
    private String productName;
    private long totalSalesValue; //How many sales the associated product has

    public ProductSalesValue() {}
    public ProductSalesValue(String productName, long salesQuantity) {
        this.productName = productName;
        this.totalSalesValue = salesQuantity;
    }

    public String getProductName() {return productName;}
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public long getTotalSalesValue() {
        return totalSalesValue;
    }
    public void setTotalSalesValue(long totalSalesValue) {
        this.totalSalesValue = totalSalesValue;
    }

    @Override
    public String toString() {
        return "ProductSales{" +
                "productName='" + productName + '\'' +
                ", salesQuantity=" + totalSalesValue +
                '}';
    }
}
