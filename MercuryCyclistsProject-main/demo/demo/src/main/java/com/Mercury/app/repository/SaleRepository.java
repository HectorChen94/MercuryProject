package com.Mercury.app.repository;

import com.Mercury.app.model.SalesDomain.Aggregate.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>
{

}
