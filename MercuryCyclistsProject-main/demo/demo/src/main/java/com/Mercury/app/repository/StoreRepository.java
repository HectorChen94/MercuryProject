package com.Mercury.app.repository;

import com.Mercury.app.model.SalesDomain.Aggregate.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>
{

    Optional<Store> findStoreById(Long id);
}
