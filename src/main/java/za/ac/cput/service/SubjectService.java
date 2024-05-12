package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subject;
import za.ac.cput.repository.SubjectRepository;

@Service
public class SubjectService implements IService<Subject,String> {
    private final SubjectRepository repository;

    @Autowired
    public SubjectService(SubjectRepository repository){
        this.repository = repository;
    }

    @Override
    public Subject create(Subject object) {
        return repository.save(object);
    }

    @Override
    public Subject read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Subject update(Subject object) {
        if(repository.findById(object.getSubjectCode()).orElse(null)!= null) {
            return repository.save(object);
        }
        else return null;
    }

    @Override
    public void delete(String s) {
        repository.deleteById(s);
    }
}
