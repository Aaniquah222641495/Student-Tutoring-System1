package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.api.TutorApiDelegate;
import za.ac.cput.domain.Tutor;
import za.ac.cput.dto.TutorDTO;
import za.ac.cput.factory.TutorFactory;
import za.ac.cput.service.TutorService;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
public class TutorController implements TutorApiDelegate {
    private TutorService service;

    public TutorController(TutorService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<TutorDTO> addTutor(TutorDTO body) {
        Tutor tutor = TutorFactory.buildTutor(body.getName(),body.getLastName(), body.getPhoneNumber(), body.getPassword(), body.getEmail());
        service.create(tutor);
        return ResponseEntity.ok().body(body);

    }

    @Override
    public ResponseEntity<Void> deleteTutor(Long tutorId) {
        service.delete(tutorId);
        return ResponseEntity.ok().body(null);
    }

    @Override
    public ResponseEntity<List<TutorDTO>> getAllTutors() {
        List<TutorDTO> list =new ArrayList<>();
        for(Tutor tutor : service.getAll()){
            TutorDTO dto = new TutorDTO(tutor.getFirstName(), tutor.getLastName(), tutor.getEmail(),tutor.getPhoneNumber(),tutor.getPassword());
            dto.setTutorId(tutor.getId());
            list.add(dto);
        }
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<TutorDTO> getTutorById(Long tutorId) {
        Tutor tutor= service.read(tutorId);
        TutorDTO dto = new TutorDTO(tutor.getFirstName(), tutor.getLastName(), tutor.getEmail(),tutor.getPhoneNumber(),tutor.getPassword());
        dto.setTutorId(tutor.getId());
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<TutorDTO> updateTutor(Long tutorId, TutorDTO body) {
        Tutor tutor = TutorFactory.buildTutor(tutorId,body.getName(), body.getLastName(), body.getPhoneNumber(), body.getPassword(), body.getEmail());
        service.update(tutor);
        body.setTutorId(tutor.getId());
        return ResponseEntity.ok().body(body);
    }
}
