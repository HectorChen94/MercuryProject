package csci318.demo.controller;

import csci318.demo.service.SaleInteractiveQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandQueryController {

    @Autowired
    SaleInteractiveQuery saleInteractiveQuery;

    @GetMapping("/sales/{sale_Number}/quantity")
    long getSaleQuantityByName(@PathVariable String sale_Number) {
        return saleInteractiveQuery.getProductSalesValue(sale_Number);
    }

    @GetMapping("/sales/all")
    List<String> getAllSales() {
        return saleInteractiveQuery.getSaleList();
    }


    @GetMapping("/sales/{sale_Number}/parts")
    List<String> getAllPartsBySale(@PathVariable String sale_Number) {
        return  saleInteractiveQuery.getPartListBySale(sale_Number);
    }

    @GetMapping("/sales/all-parts")
    List<String> getAllEquipments() {
        return  saleInteractiveQuery.getpPartList();
    }

}
