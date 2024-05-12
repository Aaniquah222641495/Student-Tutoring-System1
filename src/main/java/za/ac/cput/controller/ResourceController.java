package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Resource;
import za.ac.cput.service.ResourceService;

import javax.xml.crypto.OctetStreamData;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    ResourceService service;
    @GetMapping("/get/{id}")
    public Resource getById(@PathVariable String id){return service.read(id);}

    @PostMapping(path ="/create" , consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Resource create(@RequestPart Resource resource, @RequestPart MultipartFile file) throws IOException {
        resource = new Resource.Builder().copy(resource).setResource(file.getBytes()).build();
        return service.create(resource);
    }


}
