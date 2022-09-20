package com.Mercury.app.service;

import com.Mercury.app.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleService
{
    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {this.saleRepository = saleRepository;}

}
