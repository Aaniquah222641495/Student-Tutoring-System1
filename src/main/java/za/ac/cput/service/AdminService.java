package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.AdminRepository;

@Service
public class AdminService implements IService<Admin,Integer>{

    private final AdminRepository repository;

    @Autowired
    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public Admin create(Admin object) {
        return repository.save(object);
    }

    @Override
    public Admin read(Integer integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Admin update(Admin object) {
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
