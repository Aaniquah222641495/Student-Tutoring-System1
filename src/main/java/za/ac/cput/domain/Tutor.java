package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;
import java.util.Set;

@Entity
@Builder
@Getter
@Table(name="TUTOR")
@PrimaryKeyJoinColumn(name = "tutor_id")
public class Tutor extends User{

    @OneToMany (mappedBy = "tutor")
    private Set<StudentTutorSubject> enrollments;

    public Tutor() {}
}
