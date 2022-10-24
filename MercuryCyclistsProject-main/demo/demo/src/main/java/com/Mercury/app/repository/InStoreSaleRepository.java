package com.Mercury.app.repository;

import com.Mercury.app.model.SalesDomain.Aggregate.InStoreSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InStoreSaleRepository extends JpaRepository<InStoreSale, String>
{
  Optional<InStoreSale> findInStoreSaleById(Long id);
}
