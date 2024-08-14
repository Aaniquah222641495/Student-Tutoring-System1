package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.api.SubjectApiDelegate;
import za.ac.cput.domain.Subject;
import za.ac.cput.dto.SubjectDTO;
import za.ac.cput.factory.SubjectFactory;
import za.ac.cput.service.SubjectService;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
public class SubjectController implements SubjectApiDelegate {
    private SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<SubjectDTO> addSubject(SubjectDTO body) {
        Subject subject = SubjectFactory.buildSubject(body.getSubjectCode(), body.getSubjectName());
        service.create(subject);
        return ResponseEntity.ok().body(body);
    }

    @Override
    public ResponseEntity<Void> deleteSubject(Long subjectId) {
        service.delete(subjectId);
        return ResponseEntity.ok().body(null);
    }

    @Override
    public ResponseEntity<List<SubjectDTO>> getAllSubject() {
        List<SubjectDTO> list = new ArrayList<>();
        for(Subject subject : service.getAll()) {
            SubjectDTO dto = new SubjectDTO(subject.getSubjectCode(), subject.getName());
            dto.setSubjectId(subject.getId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<SubjectDTO> getSubjectById(Long subjectId) {
        Subject subject = service.read(subjectId);
        SubjectDTO dto = new SubjectDTO(subject.getSubjectCode(), subject.getName());
        dto.setSubjectId(subject.getId());
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<SubjectDTO> updateSubject(Long subjectId, SubjectDTO body) {
        Subject subject = SubjectFactory.buildSubject(subjectId, body.getSubjectCode(),body.getSubjectName());
        service.update(subject);
        body.setSubjectId(subject.getId());
        return ResponseEntity.ok().body(body);
    }
}
