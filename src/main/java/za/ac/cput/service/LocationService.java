package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Location;
import za.ac.cput.repository.LocationRepository;

@Service
public class LocationService implements IService<Location, Integer> {

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
    public Location read(Integer integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Location update(Location object) {
        if(repository.findById(object.getLocationId()).orElse(null)!= null) {
            return repository.save(object);
        }
        else return null;
    }

    @Override
    public void delete(Integer integer) {
        repository.deleteById(integer);
    }
}
