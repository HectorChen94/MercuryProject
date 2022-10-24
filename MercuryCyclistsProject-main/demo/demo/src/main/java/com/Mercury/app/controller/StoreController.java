package com.Mercury.app.controller;

import com.Mercury.app.model.SalesDomain.Aggregate.Sale;
import com.Mercury.app.model.SalesDomain.Aggregate.Store;
import com.Mercury.app.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    
    @PostMapping("/addnewstore")
    public void addNewStore(@RequestBody Store store) { storeService.addNewStore(store); }

}
