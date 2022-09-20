package com.Mercury.app.service;

import com.Mercury.app.repository.InStoreSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InStoreSaleService
{
    private final InStoreSaleRepository inStoreSaleRepository;

    @Autowired
    public InStoreSaleService(InStoreSaleRepository inStoreSaleRepository) {this.inStoreSaleRepository = inStoreSaleRepository;}
}
