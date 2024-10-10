package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.api.AdminApiDelegate;
import za.ac.cput.domain.Admin;
import za.ac.cput.dto.AdminDTO;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.service.AdminService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
public class AdminController implements AdminApiDelegate {

    private AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }
    @Override
    public ResponseEntity<AdminDTO> createAdmin(AdminDTO body) {
        Admin admin = AdminFactory.buildAdmin(body.getName(), body.getLastName(), body.getPhoneNumber(), body.getPassword(), body.getEmail());
        body.setId(service.create(admin).getId());
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<Void> deleteAdmin(Long adminId) {
        service.delete(adminId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<AdminDTO> getAdminById(Long adminId) {
        Admin admin = service.read(adminId);
        AdminDTO dto = new AdminDTO(admin.getFirstName(),admin.getLastName(),admin.getEmail(),admin.getPhoneNumber(), admin.getPassword());
        dto.setId(admin.getId());
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<AdminDTO> updateAdmin(Long adminId, AdminDTO body) {
        Admin admin = AdminFactory.buildAdmin(adminId,body.getName(),body.getLastName(),body.getPhoneNumber(),body.getPassword(),body.getEmail());
        service.update(admin);
        body.setId(admin.getId());
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        List<AdminDTO> list =new ArrayList<>();
        for(Admin admin : service.getAll()){
            AdminDTO dto = new AdminDTO(admin.getFirstName(),admin.getLastName(),admin.getEmail(),admin.getPhoneNumber(), admin.getPassword());
            dto.setId(admin.getId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<AdminDTO> authenticateAdmin(String email, String password) {
        Admin admin = service.authenticate(email,password);
        if(admin == null) return ResponseEntity.badRequest().body(null);
        AdminDTO dto = new AdminDTO(admin.getFirstName(),admin.getLastName(),admin.getEmail(),admin.getPhoneNumber(), admin.getPassword());
        dto.setId(admin.getId());
        return ResponseEntity.ok().body(dto);
    }
}
