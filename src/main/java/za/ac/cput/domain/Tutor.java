package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.experimental.SuperBuilder;



@Entity
@SuperBuilder
@Getter
@Table(name="TUTOR")
@PrimaryKeyJoinColumn(name = "tutor_id")
public class Tutor extends User{

    public Tutor() {
    }
}
