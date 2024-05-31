package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Calendar_Entry;

import java.util.Date;
import java.util.List;

@Repository
public interface Calendar_Entry_Repository extends JpaRepository<Calendar_Entry, Integer> {

    List<Calendar_Entry> findByStudentId(Integer studentId);

    List<Calendar_Entry> findByTutorId(Integer tutorId);

    List<Calendar_Entry> findBySubjectCode(String subjectCode);

    List<Calendar_Entry> findByDateBetween(Date startDate, Date endDate);

}