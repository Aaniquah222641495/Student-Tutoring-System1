package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
