package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Calendar_Entry;

import java.util.Date;
import java.util.List;

@Repository
public interface Calendar_Entry_Repository extends JpaRepository<Calendar_Entry, Integer> {

    // Find calendar entries by student ID
    List<Calendar_Entry> findByStudentId(Integer studentId);

    // Find calendar entries by tutor ID
    List<Calendar_Entry> findByTutorId(Integer tutorId);

    // Find calendar entries by subject code
    List<Calendar_Entry> findBySubjectCode(String subjectCode);

    // Find calendar entries by date
    List<Calendar_Entry> findByDateBetween(Date startDate, Date endDate);

}