package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subject;
import za.ac.cput.repository.SubjectRepository;

@Service
public class SubjectService implements IService<Subject,Integer> {
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
    public Subject read(Integer integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Subject update(Subject object) {
        return repository.save(object);
    }

    @Override
    public void delete(Integer integer) {
        repository.deleteById(integer);
    }
}
