package za.ac.cput.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.api.AdminApiDelegate;
import za.ac.cput.domain.Admin;
import za.ac.cput.dto.AdminDTO;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.service.AdminService;


@RestController
public class AdminController implements AdminApiDelegate {
    @Autowired
    private AdminService service;

    public AdminController() {

    }
    @Override
    public ResponseEntity<AdminDTO> createAdmin(AdminDTO body) {
        Admin admin = AdminFactory.buildAdmin(body.getName(), body.getLastName(), body.getPhoneNumber(), body.getPassword(), body.getEmail());
        service.create(admin);
        return ResponseEntity.ok().body(body);
    }
}
