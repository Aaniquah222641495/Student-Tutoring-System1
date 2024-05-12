package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Tutor;
import za.ac.cput.repository.TutorRepository;

@Service
public class TutorService implements IService<Tutor, Integer>{

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
    public Tutor read(Integer integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Tutor update(Tutor object) {
        if(repository.findById(object.getId()).orElse(null)!= null) {
            return repository.save(object);
        }
        else return null;
    }

    @Override
    public void delete(Integer integer) {
        repository.deleteById(integer);
    }
}
