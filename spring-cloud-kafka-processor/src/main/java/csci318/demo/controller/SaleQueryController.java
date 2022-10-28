package csci318.demo.controller;

import csci318.demo.service.SaleInteractiveQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleQueryController
{
    @Autowired
    SaleInteractiveQuery saleInteractiveQuery;

    //Returns the quantity of sales of a particular product
    @GetMapping("/product/{productName}/quantity")
    long getProductSalesByName(@PathVariable String productName) {
        return saleInteractiveQuery.getProductSales(productName);
    }

    @GetMapping("/product/all")
    List<String> getAllProducts()
    {
        return saleInteractiveQuery.getProductList();
    }

    //Returns all of the sales of a particular product, not just the quantity
    @GetMapping("/product/{productName}/sales")
    List<String> getSalesByProduct(@PathVariable String productName)
    {
        return  saleInteractiveQuery.getSalesByProduct(productName);
    }

    @GetMapping("/sale/all-sales")
    List<String> getAllSales() {
        return  saleInteractiveQuery.getSalesList();
    }

    @GetMapping("/product/{productName}/totalSalesValue")
    List<String> getTotalSalesValueByProduct(@PathVariable String productName)
    { return saleInteractiveQuery.getTotalSalesOfProduct(productName); }

}
