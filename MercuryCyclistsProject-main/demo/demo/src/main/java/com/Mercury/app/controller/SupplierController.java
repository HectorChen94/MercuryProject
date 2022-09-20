package com.Mercury.app.controller;

import com.Mercury.app.model.ProcurementDomain.Supplier;
import com.Mercury.app.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/supplier")
public class SupplierController
{
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) { this.supplierService = supplierService; }

    //Use case 3 (Look up all suppliers basic info including their contact(s))
    @GetMapping("/all")
    public List<Supplier> getAllSuppliers()
    {
        return supplierService.getAllSuppliers();
    }

    //Use case 3 (Look up specific supplier basic info including their contact(s))
    @GetMapping("{supplierId}")
    public Supplier findSupplierById(@PathVariable("supplierId") Long id) {return supplierService.findSupplierById(id);}

    //Use case 6 (look up supplier by part)
    @GetMapping("/ofpart/{partId}")
    public List<Supplier> findSuppliersGivenPartId(@PathVariable("partId")  Long partId) { return supplierService.getSuppliersWithPartId(partId); }

    //Use case 1 & 2 (create Supplier and optionally create its contact too)
    @PostMapping("/add")
    public void addNewSupplier(@RequestBody Supplier supplier) { supplierService.addNewSupplier(supplier);}

    //Use case 1 (update supplier)
    @PutMapping("/update/{supplierId}")
    public void updateSupplier(
            @PathVariable("supplierId") Long id,
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String base)
    {
        supplierService.updateSupplier(id,companyName, base);
    }

    //Use case 2 (update supplier contact)
    @PutMapping("{supplierId}/updatecontact/{contactId}")
    public void updateSupplierContact(
            @PathVariable("supplierId") Long supplierId,
            @PathVariable("contactId") Long contactId,
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String phone,
            @RequestParam(required=false) String email,
            @RequestParam(required=false) String position)
    {
        supplierService.updateSupplierContact(supplierId, contactId, name, phone, email, position);
    }
}
