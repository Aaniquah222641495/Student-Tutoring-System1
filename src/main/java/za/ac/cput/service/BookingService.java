package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;
import za.ac.cput.repository.BookingRepository;

@Service
public class BookingService implements IService<Booking, Integer>{
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
    public Booking read(Integer integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Booking update(Booking object) {
        if(repository.findById(object.getBooking_id()).orElse(null)!= null) {
            return repository.save(object);
        }
        else return null;
    }

    @Override
    public void delete(Integer integer) {
        repository.deleteById(integer);
    }
}
