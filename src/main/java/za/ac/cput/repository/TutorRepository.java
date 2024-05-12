package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Integer> {
}
