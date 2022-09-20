package com.Mercury.app.service;

import com.Mercury.app.model.InventoryDomain.Part;
import com.Mercury.app.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PartService
{
    private final PartRepository partRepository;

    @Autowired
    public PartService(PartRepository partRepository) {this.partRepository = partRepository;}

    public List<Part> findAllParts()
    {
        return partRepository.findAll();
    }

    public void addNewPart(Part part)
    {
        Optional<Part> partOptional = partRepository.findPartById(part.getId());
        if (partOptional.isPresent()) { throw new IllegalStateException("part with Id:" + part.getId() + " already exists"); }
        partRepository.save(part);
    }

    @Transactional
    public void updatePart(Long partId, String name, String description)
    {
        Part part = partRepository.findById(partId).orElseThrow(
                () -> new IllegalStateException("No part found with Id " + partId));

        if (name!=null && name.length()>0 && !Objects.equals(part.getName(),name)) { part.setName(name); }
        if (!Objects.equals(part.getId(),partId)) { part.setPartId(partId); }
        if (description!=null && !Objects.equals(part.getDescription(),description)) { part.setDescription(description); }
    }
}
