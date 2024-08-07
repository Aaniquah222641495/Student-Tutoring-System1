package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.api.StudentApiDelegate;
import za.ac.cput.domain.Student;
import za.ac.cput.dto.StudentDTO;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.service.StudentService;

@RestController
public class StudentController implements StudentApiDelegate {

    private final StudentService service;


    public StudentController(StudentService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<StudentDTO> addStudent(StudentDTO body) {
        Student student = StudentFactory.createStudent(body.getName(),body.getLastName(), body.getPhoneNumber(), body.getPassword(), body.getEmail(), body.getStudentNumber());
        service.create(student);
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<Void> deleteStudent(Long studentId) {
        service.delete(studentId);
        return ResponseEntity.ok().body(null);
    }

    @Override
    public ResponseEntity<StudentDTO> getStudentById(Long studentId) {
        Student student = service.read(studentId);
        StudentDTO dto = new StudentDTO(student.getFirstName(),student.getLastName(),student.getEmail(),student.getPhoneNumber(), student.getPassword(),student.getStudentNumber());
        dto.setStudentId(studentId);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<StudentDTO> updateStudent(Long studentId, StudentDTO body) {
        Student student = StudentFactory.createStudent(studentId,body.getName(), body.getLastName(), body.getPhoneNumber(), body.getPassword(), body.getEmail(), body.getStudentNumber());
        service.update(student);
        body.setStudentId(student.getId());
        return ResponseEntity.ok().body(body);
    }
}
