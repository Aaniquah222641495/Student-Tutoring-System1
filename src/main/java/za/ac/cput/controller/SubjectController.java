package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Subject;
import za.ac.cput.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService service;

    @GetMapping("/get/{id}")
    public Subject getSubject(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/create")
    public Subject createSubject(@RequestBody Subject subject){
        return service.create(subject);
    }

    @PostMapping("/update")
    public Subject updateSubject(@RequestBody Subject subject){
        return service.update(subject);
    }

    @PostMapping("/delete/{id}")
    public void deleteSubject(@PathVariable String id){
        service.delete(id);
    }

}
