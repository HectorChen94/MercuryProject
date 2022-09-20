package com.Mercury.app.repository;

import com.Mercury.app.model.ProcurementDomain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>
{
    //SELECT * FROM contact WHERE email == ?
    Optional<Contact> findContactByEmail(String email);
}
