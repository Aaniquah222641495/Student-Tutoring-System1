package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService implements IService<Student, Long> {

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
    public Student read(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Student update(Student object) {
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
    public List<Student> getAll() {
        return repository.findAll();
    }
}
