package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Review;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Tutor;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByAuthor(Student author);
    List<Review> findAllByTutor(Tutor tutor);

}
