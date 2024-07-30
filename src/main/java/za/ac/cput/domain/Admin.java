package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@PrimaryKeyJoinColumn(name = "admin_id")
public class Admin extends User{

    public Admin() {}

}
