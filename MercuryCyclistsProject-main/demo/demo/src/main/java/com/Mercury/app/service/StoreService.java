package com.Mercury.app.service;

import com.Mercury.app.model.SalesDomain.Aggregate.Sale;
import com.Mercury.app.model.SalesDomain.Aggregate.Store;
import com.Mercury.app.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    public void addNewStore(Store store)
    {
        Optional<Store> storeOptional = storeRepository.findStoreById(store.getId());
        if (storeOptional.isPresent()) { throw new IllegalStateException("Store with id " + store.getId() + " already established"); }
        storeRepository.save(store);
    }
}
