package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.StudentTutorSubject;
import za.ac.cput.domain.StudentTutorSubjectID;

public interface StudentTutorSubjectRepository extends JpaRepository<StudentTutorSubject, StudentTutorSubjectID> {
}
