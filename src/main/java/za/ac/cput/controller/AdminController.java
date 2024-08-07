package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.api.AdminApiDelegate;
import za.ac.cput.domain.Admin;
import za.ac.cput.dto.AdminDTO;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.service.AdminService;

@RestController
public class AdminController implements AdminApiDelegate {

    private AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }
    @Override
    public ResponseEntity<AdminDTO> createAdmin(AdminDTO body) {
        Admin admin = AdminFactory.buildAdmin(body.getName(), body.getLastName(), body.getPhoneNumber(), body.getPassword(), body.getEmail());
        service.create(admin);
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
}
