package com.Mercury.app.controller;

import com.Mercury.app.model.SalesDomain.Sale;
import com.Mercury.app.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v3/store")
public class StoreController
{
    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {this.storeService = storeService;}

    //Dummy test method
    @GetMapping("/dothething")
    public List<String> thing()
    {
        List<String> returner = new ArrayList<>();
        returner.add("Monster\n\n\n\n\n YARRRRR!\n");
        return returner;
    }

    //Use case 9 (look up sales by store)
    @GetMapping("{storeId}/sales")
    public List<Sale> getSalesByStore(@PathVariable Long storeId) { return storeService.getSalesByStore(storeId); }

}
