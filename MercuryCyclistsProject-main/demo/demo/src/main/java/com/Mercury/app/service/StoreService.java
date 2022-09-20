package com.Mercury.app.service;

import com.Mercury.app.model.SalesDomain.Sale;
import com.Mercury.app.model.SalesDomain.Store;
import com.Mercury.app.model.ProcurementDomain.Supplier;
import com.Mercury.app.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService
{
    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {this.storeRepository = storeRepository;}

    public List<Sale> getSalesByStore(Long storeId)
    {
        Optional<Store> storeOptional = storeRepository.findById(storeId);
        if (!(storeOptional.isPresent())) { throw new IllegalStateException("Store with id " + storeId + " not found"); }
        return storeOptional.get().getInStoreSales();
    }
}
