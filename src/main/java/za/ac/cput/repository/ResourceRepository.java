package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, String> {
}
