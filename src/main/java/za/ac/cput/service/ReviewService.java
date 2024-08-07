package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;

@Service
public class ReviewService implements IService<Review,Long> {
    private ReviewRepository repository;

    @Autowired
    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public Review create(Review object) {
        return repository.save(object);
    }

    @Override
    public Review read(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Review update(Review object) {
        if(repository.findById(object.getId()).orElse(null)!= null) {
            return repository.save(object);
        }
        else return null;
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }
}
