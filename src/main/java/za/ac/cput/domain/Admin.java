package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@ToString
@PrimaryKeyJoinColumn(name = "admin_id")
public class Admin extends User{
    public Admin() {
    }
}
