package com.Mercury.app.repository;

import com.Mercury.app.model.SalesDomain.InStoreSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InStoreSaleRepository extends JpaRepository<InStoreSale, String>
{

}
