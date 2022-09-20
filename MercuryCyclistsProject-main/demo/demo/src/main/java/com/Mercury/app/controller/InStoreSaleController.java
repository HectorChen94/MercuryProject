package com.Mercury.app.controller;

import com.Mercury.app.service.InStoreSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v3/inStoreSale")
public class InStoreSaleController
{
    private final InStoreSaleService inStoreSaleService;

    @Autowired
    public InStoreSaleController(InStoreSaleService inStoreSaleService) {this.inStoreSaleService = inStoreSaleService;}
}
