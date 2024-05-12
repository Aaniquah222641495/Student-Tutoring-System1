package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Calendar_Entry;

public interface Calendar_Entry_Repository extends JpaRepository<Calendar_Entry, Integer> {
}
