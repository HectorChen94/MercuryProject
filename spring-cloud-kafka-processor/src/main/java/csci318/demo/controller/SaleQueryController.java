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

    @GetMapping("/product/{productName}/totalSalesValue")
    String getTotalSalesValueByProduct(@PathVariable String productName)
    { return saleInteractiveQuery.getTotalSalesOfProduct(productName); }

}

