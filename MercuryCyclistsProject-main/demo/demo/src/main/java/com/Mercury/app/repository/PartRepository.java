package com.Mercury.app.repository;

import com.Mercury.app.model.InventoryDomainPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Long>
{
    Optional<Part> findPartById(Long partId);
}

