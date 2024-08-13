package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subject;
import za.ac.cput.repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectService implements IService<Subject,Long> {
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
    public Subject read(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Subject update(Subject object) {
        if(repository.findById(object.getId()).orElse(null)!= null) {
            return repository.save(object);
        }
        else return null;
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public List<Subject> getAll() {
        return repository.findAll();
    }
}
