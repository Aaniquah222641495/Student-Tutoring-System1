package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.api.StudentApiDelegate;
import za.ac.cput.domain.Student;
import za.ac.cput.dto.StudentDTO;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.service.StudentService;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
public class StudentController implements StudentApiDelegate {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<StudentDTO> addStudent(StudentDTO body) {
        Student student = StudentFactory.buildStudent(body.getName(),body.getLastName(), body.getPhoneNumber(), body.getPassword(), body.getEmail(), body.getStudentNumber());
        if(student==null) return ResponseEntity.badRequest().body(null);
        body.setStudentId(service.create(student).getId());
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<Void> deleteStudent(Long studentId) {
        service.delete(studentId);
        return ResponseEntity.ok().body(null);
    }

    @Override
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> list = new ArrayList<>();
        for(Student student : service.getAll()){
            StudentDTO dto = new StudentDTO(student.getFirstName(), student.getLastName(), student.getEmail(),student.getPhoneNumber(),student.getPassword(), student.getStudentNumber());
            dto.setStudentId(student.getId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<StudentDTO> getStudentById(Long studentId) {
        Student student = service.read(studentId);
        if(student == null) return ResponseEntity.notFound().build();
        StudentDTO dto = new StudentDTO(student.getFirstName(),student.getLastName(),student.getEmail(),student.getPhoneNumber(), student.getPassword(),student.getStudentNumber());
        dto.setStudentId(student.getId());
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<StudentDTO> updateStudent(Long studentId, StudentDTO body) {
        Student student = StudentFactory.buildStudent(studentId,body.getName(), body.getLastName(), body.getPhoneNumber(), body.getPassword(), body.getEmail(), body.getStudentNumber());
        if(student==null) return ResponseEntity.notFound().build();
        service.update(student);
        body.setStudentId(student.getId());
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<StudentDTO> authenticateStudent(String email, String password) {
        Student student = service.authenticate(email, password);
        if (student == null) return ResponseEntity.badRequest().body(null);
        StudentDTO dto = new StudentDTO(student.getFirstName(),student.getLastName(),student.getEmail(),student.getPhoneNumber(), student.getPassword(),student.getStudentNumber());
        dto.setStudentId(student.getId());
        return ResponseEntity.ok().body(dto);

    }
}
