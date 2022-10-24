package com.Mercury.app.service;

import com.Mercury.app.model.ProcurementDomain.Contact;
import com.Mercury.app.model.InventoryDomain.Aggregate.Part;
import com.Mercury.app.model.InventoryDomain.Supplier;
import com.Mercury.app.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() { return supplierRepository.findAll(); }

    //Finds a supplier by Id
    public Supplier findSupplierById(Long id)
    {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (supplierOptional.isPresent()) { throw new IllegalStateException("No supplier found with id: " + id); }
        return supplierOptional.get();
    }

    //Adds a new supplier to the repository
    public void addNewSupplier(Supplier supplier)
    {
        Optional<Supplier> supplierOptional = supplierRepository.findSupplierByCompanyName(supplier.getCompanyName());
        if (supplierOptional.isPresent()) { throw new IllegalStateException("Supplier with company name " + supplier.getCompanyName() + " already established"); }
        System.out.println(supplier);
        supplierRepository.save(supplier);
    }

    //Updates attributes of a supplier
    @Transactional
    public void updateSupplier(Long id, String companyName, String base)
    {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("No supplier found with Id " + id));

        if (companyName!=null && companyName.length()>0 && !Objects.equals(supplier.getCompanyName(),companyName)) { supplier.setCompanyName(companyName); }
        if (base!=null && base.length()>0 && !Objects.equals(supplier.getBase(),base))   { supplier.setBase(base); }
    }

    //Updates a specific contact of a supplier
    public void updateSupplierContact(Long supplierId, Long contactId, String name, String phone, String email, String position)
    {
        //May contain null values for name, phone, email and position
        Optional<Supplier> supplierOptional = supplierRepository.findById(supplierId);
        if (!(supplierOptional.isPresent())) { throw new IllegalStateException("Supplier with id " + supplierId + " not found"); }
        else
        {
            Supplier supplier = supplierOptional.get();
            List<Contact> contacts = supplier.getContacts();
            for (Contact contact: contacts)
            {
                if (contact.getId() == contactId)
                {
                    if (name != "") {contact.setName(name);}
                    if (phone != "") {contact.setPhone(phone);}
                    if (email != "") {contact.setEmail(email);}
                    if (position != "") {contact.setPosition(position);}
                    break;
                }
            }
        }
    }

    //Use case 6
    //Returns a list of all suppliers that contain a part with this partId
    public List<Supplier> getSuppliersWithPartId(Long partId)
    {
        List<Supplier> allSuppliers = supplierRepository.findAll();
        ArrayList<Supplier> validSuppliers = new ArrayList<>();
        for (Supplier supplier: allSuppliers)
        {
            List<Part> supplierParts = supplier.getParts();
            for (Part part :supplierParts)
            {
                if (part.getId() == partId) { validSuppliers.add(supplier); break; }
            }
        }

        //In case nothing was found
        if (validSuppliers.size() == 0)
        {
            throw new IllegalStateException("No supplier found that contains a part with part with part Id: " + partId);
        }
        return validSuppliers;
    }
}
