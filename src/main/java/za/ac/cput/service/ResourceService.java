package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Resource;
import za.ac.cput.repository.AdminRepository;
import za.ac.cput.repository.ResourceRepository;

@Service
public class ResourceService implements IService<Resource, String> {
    private final ResourceRepository repository;
    @Autowired
    public ResourceService(ResourceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Resource create(Resource object) {
        return repository.save(object);
    }

    @Override
    public Resource read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Resource update(Resource object) {
        if(repository.findById(object.getId()).orElse(null)!= null) {
            return repository.save(object);
        }
        else return null;
    }

    @Override
    public void delete(String s) {
        repository.deleteById(s);
    }

}
