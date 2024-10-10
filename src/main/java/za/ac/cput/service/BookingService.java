package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.*;
import za.ac.cput.repository.BookingRepository;

import java.util.List;

@Service
public class BookingService implements IService<Booking, Long>{
    private final BookingRepository repository;

    @Autowired
    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Booking create(Booking object) {
        return repository.save(object);
    }

    @Override
    public Booking read(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Booking update(Booking object) {
        if(repository.findById(object.getBookingId()).orElse(null)!= null) {
            return repository.save(object);
        }
        else return null;
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public List<Booking> getAll() {
        return repository.findAll();
    }

    public List<Booking> findByStudent(Student student) {
        return repository.findAllByStudent(student);
    }

    public List<Booking> findByTutor(Tutor tutor) {
        return repository.findAllByTutor(tutor);
    }

    public List<Booking> findByLocation(Location location) {
        return repository.findAllByLocation(location);
    }

    public List<Booking> findBySubject(Subject subject) {
        return repository.findAllBySubject(subject);
    }
}
