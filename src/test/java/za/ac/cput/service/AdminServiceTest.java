package za.ac.cput.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.repository.AdminRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    private static Admin admin;

    @BeforeAll
    static void setUp() {
        admin = AdminFactory.buildAdmin("Mohamed", "Zouheir", "0624770258", "gogo", "mohamedzo@gmail.com");
    }

    @Test
    void create() {
        adminService.create(admin);
        assertNotNull(adminRepository.findById(admin.getId()));
    }

    @Disabled
    @Test
    void read() {
    }

    @Disabled
    @Test
    void update() {
    }

    @Disabled
    @Test
    void delete() {
    }
}