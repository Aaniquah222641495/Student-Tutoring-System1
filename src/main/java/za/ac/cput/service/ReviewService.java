package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Tutor;
import za.ac.cput.repository.ReviewRepository;

import java.util.List;

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

    @Override
    public List<Review> getAll() {
        return repository.findAll();
    }

    public List<Review> getReviewsByStudent(Student student) {
        return repository.findAllByAuthor(student);
    }

    public List<Review> getReviewsByTutor(Tutor tutor) {
        return repository.findAllByTutor(tutor);
    }
}
