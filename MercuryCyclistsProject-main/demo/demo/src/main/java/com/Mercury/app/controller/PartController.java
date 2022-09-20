package com.Mercury.app.controller;

import com.Mercury.app.model.InventoryDomain.Part;
import com.Mercury.app.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/part")
public class PartController {
    private final PartService partService;

    @Autowired
    public PartController(PartService partService)
    {
        this.partService = partService;
    }

    //Technically unnecessary, but nice ig
    @GetMapping("/test")
    public List<Part> test()
    {
        return partService.findAllParts();
    }


    //Use case 4 (Create part)
    @PostMapping
    public void addNewPart(@RequestBody Part part)
    {
        partService.addNewPart(part);
    }

    //Use case 4 (Update part)
    @PutMapping(path = {"{partId}"})
    public void updatePart(
            @PathVariable Long partId,
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String description)
    {
        partService.updatePart(partId, name, description);
    }
}
