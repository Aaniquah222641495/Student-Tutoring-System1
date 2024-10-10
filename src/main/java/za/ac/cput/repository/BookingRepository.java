package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.*;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByTutor(Tutor tutor);
    List<Booking> findAllByStudent(Student student);
    List<Booking> findAllByLocation(Location location);
    List<Booking> findAllBySubject(Subject subject);
}
