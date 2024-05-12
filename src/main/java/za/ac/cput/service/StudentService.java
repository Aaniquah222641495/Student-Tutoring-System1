package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.StudentRepository;

@Service
public class StudentService implements IService<Student, Integer> {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student create(Student object) {
        return repository.save(object);
    }

    @Override
    public Student read(Integer integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Student update(Student object) {
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
