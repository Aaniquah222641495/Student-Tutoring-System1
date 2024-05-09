package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService service;

    @GetMapping("/get/{id}")
    public Admin getById(@PathVariable Integer id){
        return service.read(id);
    }

    @PostMapping("/create")
    public Admin create(@RequestBody Admin admin){
        return service.create(admin);
    }
}
