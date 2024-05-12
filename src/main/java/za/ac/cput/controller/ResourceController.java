package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Resource;
import za.ac.cput.service.ResourceService;
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    ResourceService service;
    @GetMapping("/get/{id}")
    public Resource getById(@PathVariable Integer id){return service.read(id);}
    @PostMapping("/create")
    public Resource create(@RequestBody Resource resource){return service.create(resource);}


}
