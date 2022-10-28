package csci318.demo.model;

public class ProductSalesValue
{
    private String productName;
    private long totalSalesValue; //The total value of all of the sales of the associated product

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
