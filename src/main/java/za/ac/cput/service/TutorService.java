package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Tutor;
import za.ac.cput.repository.TutorRepository;

import java.util.List;

@Service
public class TutorService implements IService<Tutor, Long>{

    private final TutorRepository repository;

    @Autowired
    public TutorService(TutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tutor create(Tutor object) {
        return repository.save(object);
    }

    @Override
    public Tutor read(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Tutor update(Tutor object) {
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
    public List<Tutor> getAll() {
        return repository.findAll();
    }
}
