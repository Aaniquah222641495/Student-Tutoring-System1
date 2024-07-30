package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
