package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Location;
import za.ac.cput.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService implements IService<Location, Long> {

    private final LocationRepository repository;

    @Autowired
    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location create(Location object) {
        return repository.save(object);
    }

    @Override
    public Location read(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Location update(Location object) {
        if(repository.findById(object.getLocationId()).orElse(null)!= null) {
            return repository.save(object);
        }
        else return null;
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public List<Location> getAll() {
        return repository.findAll();
    }
}
