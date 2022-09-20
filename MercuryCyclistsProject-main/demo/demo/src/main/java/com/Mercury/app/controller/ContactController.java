package com.Mercury.app.controller;

import com.Mercury.app.model.ProcurementDomain.Contact;
import com.Mercury.app.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/contact")
public class ContactController
{
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService)
    {
        this.contactService = contactService;
    }

    @GetMapping("/all")
    public List<Contact> getAllContacts()
    {
        return contactService.getAllContacts();
    }

    @PostMapping("/add")
    public void addNewContact(@RequestBody Contact contact)
    {
        contactService.addNewContact(contact);
    }

    @PutMapping(path = {"{contactId}"})
    public void updateContact(
            @PathVariable("contactId") Long id,
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String phone,
            @RequestParam(required=false) String email,
            @RequestParam(required=false) String position)
    {
        contactService.updateContact(id, name, phone, email, position);
    }
}