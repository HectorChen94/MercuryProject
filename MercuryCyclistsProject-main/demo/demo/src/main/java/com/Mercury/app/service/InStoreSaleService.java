package com.Mercury.app.service;

import com.Mercury.app.model.SalesDomain.Aggregate.InStoreSale;
import com.Mercury.app.repository.InStoreSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InStoreSaleService
{
    private final InStoreSaleRepository inStoreSaleRepository;

    @Autowired
    public InStoreSaleService(InStoreSaleRepository inStoreSaleRepository) {this.inStoreSaleRepository = inStoreSaleRepository;}
    
    public void addNewInStoreSale(InStoreSale inStoreSale)
    {
        Optional<InStoreSale> inStoreSaleOptional = inStoreSaleRepository.findInStoreSaleById(inStoreSale.getId());
        if (inStoreSaleOptional.isPresent()) { throw new IllegalStateException("Sale with id " + inStoreSale.getId() + " already established"); }
        inStoreSaleRepository.save(inStoreSale);
    }
}
