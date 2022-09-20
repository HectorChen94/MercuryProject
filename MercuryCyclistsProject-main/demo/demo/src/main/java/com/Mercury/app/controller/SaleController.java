package com.Mercury.app.controller;

import com.Mercury.app.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v3/Sale")
public class SaleController
{
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {this.saleService = saleService;}


}
