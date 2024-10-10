package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.repository.AdminRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
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
    @Order(2)
    @Test
    void authenticate(){
        Admin admin1 =adminService.authenticate("mohamedzo@gmail.com", "gog");
        assertNotNull(admin1);
    }
}