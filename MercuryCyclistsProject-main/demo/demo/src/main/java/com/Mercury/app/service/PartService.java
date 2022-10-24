package com.Mercury.app.service;

import com.Mercury.app.model.InventoryDomain.Aggregate.Part;
import com.Mercury.app.model.InventoryDomain.ValueObject.Description;
import com.Mercury.app.model.InventoryDomain.ValueObject.PartName;
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
        Optional<Part> partOptional = partRepository.findPartById(part.getPartId());
        if (partOptional.isPresent()) { throw new IllegalStateException("part with Id:" + part.getPartId() + " already exists"); }
        partRepository.save(part);
    }

    @Transactional
    public void updatePart(Long partId, PartName partName, Description description)
    {
        Part part = partRepository.findById(partId).orElseThrow(
                () -> new IllegalStateException("No part found with Id " + partId));

        if (partName!=null && partName.length()>0 && !Objects.equals(part.getPartName(),partName)) { part.setPartName(partName); }
        if (!Objects.equals(part.getPartId(),partId)) { part.setPartId(partId); }
        if (description!=null && !Objects.equals(part.getDescription(),description)) { part.setDescription(description); }
    }
}
