package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Message;

public interface MessageRepository extends JpaRepository<Message, String> {
}
