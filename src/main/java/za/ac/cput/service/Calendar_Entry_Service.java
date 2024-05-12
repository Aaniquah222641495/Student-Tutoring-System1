package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Calendar_Entry;
import za.ac.cput.repository.Calendar_Entry_Repository;

@Service
public class Calendar_Entry_Service implements IService<Calendar_Entry, Integer>{
    private final Calendar_Entry_Repository repository;

    @Autowired
    public Calendar_Entry_Service(Calendar_Entry_Repository repository) {
        this.repository = repository;
    }

    @Override
    public Calendar_Entry create(Calendar_Entry object) {
        return repository.save(object);
    }

    @Override
    public Calendar_Entry read(Integer integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Calendar_Entry update(Calendar_Entry object) {
        Integer id = object.getEntry_id();
        if (id != null && repository.existsById(id)) {
            return repository.save(object);
        }
        return null;
    }

    @Override
    public void delete(Integer integer) {
        try {
            repository.deleteById(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}