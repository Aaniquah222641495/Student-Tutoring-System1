package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Subject;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    public List<Subject> findSubjectsBySubjectCodeContainingIgnoreCase(String subjectCode);

}
