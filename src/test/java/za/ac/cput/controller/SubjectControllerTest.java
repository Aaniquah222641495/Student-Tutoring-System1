package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Subject;
import za.ac.cput.factory.SubjectFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SubjectControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl = "http://localhost:8080/subject";

    private Subject testSubject;

    @BeforeEach
    void setUp() {
        testSubject = SubjectFactory.buildSubject("ADF262S", "Application Development Fundamentals");
    }

    @Order(2)
    @Test
    void getSubject() {
        String url = baseUrl + "/get/" + testSubject.getSubjectCode();
        ResponseEntity<Subject> response = restTemplate.getForEntity(url, Subject.class);
        assertEquals(testSubject, response.getBody());
    }

    @Order(1)
    @Test
    void createSubject() {
        String url = baseUrl + "/create";
        ResponseEntity<Subject> response = restTemplate.postForEntity(url, testSubject, Subject.class);
        assertEquals(testSubject, response.getBody());

    }

    @Order(3)
    @Test
    void updateSubject() {
        String url = baseUrl + "/update";
        testSubject = new Subject.Builder().copy(testSubject).setName("Application Fuckup").build();
        ResponseEntity<Subject> response = restTemplate.postForEntity(url, testSubject, Subject.class);
        assertEquals(testSubject, response.getBody());
    }

    @Order(4)
    @Test
    void deleteSubject() {
        String url = baseUrl + "/delete/" + testSubject.getSubjectCode();
        restTemplate.postForEntity(url, testSubject, Void.class);
        url = baseUrl + "/get/" + testSubject.getSubjectCode();
        ResponseEntity<Subject> response = restTemplate.getForEntity(url, Subject.class);
        assertNull(response.getBody());
    }
}