package com.Mercury.app.repository;

import com.Mercury.app.model.SalesDomain.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>
{

}
