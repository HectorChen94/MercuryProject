package com.Mercury.app.service;

import com.Mercury.app.model.ProcurementDomain.Contact;
import com.Mercury.app.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContactService
{
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {this.contactRepository = contactRepository;}

    public List<Contact> getAllContacts()
    {
        return contactRepository.findAll();
    }

    public void addNewContact(Contact contact)
    {
        Optional<Contact> contactOptional = contactRepository.findContactByEmail(contact.getEmail());
        if (contactOptional.isPresent()) { throw new IllegalStateException("email already taken"); }
        System.out.println(contact);
        contactRepository.save(contact);
    }

    @Transactional
    public void updateContact(Long id, String name, String phone, String email, String position)
    {
        Contact contact = contactRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("No contact found with Id " + id));

        System.out.println(contact);

        if (name!=null && name.length()>0 && !Objects.equals(contact.getName(),name))       { contact.setName(name); }
        if (phone!=null && phone.length()>0 && !Objects.equals(contact.getPhone(),phone))   { contact.setPhone(phone); }
        if (email != null && email.length()>0 && !Objects.equals(contact.getEmail(),email)) { contact.setEmail(email); }
        if (position!=null && !Objects.equals(contact.getPosition(),position))              { contact.setPosition(position); }
    }
}

    @Transactional
    public void updateContact(Long id, String name, String phone, String email, String position)
    {
        Contact contact = contactRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("No contact found with Id " + id));

        System.out.println(contact);

        if (name!=null && name.length()>0 && !Objects.equals(contact.getName(),name))       { contact.setName(name); }
        if (phone!=null && phone.length()>0 && !Objects.equals(contact.getPhone(),phone))   { contact.setPhone(phone); }
        if (email != null && email.length()>0 && !Objects.equals(contact.getEmail(),email)) { contact.setEmail(email); }
        if (position!=null && !Objects.equals(contact.getPosition(),position))              { contact.setPosition(position); }
    }
}
