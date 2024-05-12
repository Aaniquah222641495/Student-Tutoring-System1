package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.StudentTutorSubject;
import za.ac.cput.domain.StudentTutorSubjectID;
import za.ac.cput.repository.StudentTutorSubjectRepository;

@Service
public class StudentTutorSubjectService implements IService<StudentTutorSubject, StudentTutorSubjectID>{
    private final StudentTutorSubjectRepository repository;
    @Autowired
    public StudentTutorSubjectService(StudentTutorSubjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentTutorSubject create(StudentTutorSubject object) {
        return repository.save(object);
    }

    @Override
    public StudentTutorSubject read(StudentTutorSubjectID studentTutorSubjectID) {
        return repository.findById(studentTutorSubjectID).orElse(null);
    }

    @Override
    public StudentTutorSubject update(StudentTutorSubject object) {
        if(repository.findById(object.getId()).orElse(null)!= null) {
            return repository.save(object);
        }
        else return null;
    }

    @Override
    public void delete(StudentTutorSubjectID studentTutorSubjectID) {
        repository.deleteById(studentTutorSubjectID);
    }
}
