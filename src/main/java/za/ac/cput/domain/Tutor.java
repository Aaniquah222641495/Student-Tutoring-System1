package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Set;


@Entity
@SuperBuilder
@Getter
@Table(name="TUTOR")
@PrimaryKeyJoinColumn(name = "tutor_id")
public class Tutor extends User{

    @ManyToMany
    @JoinTable(
            name = "tutor_subject",
            joinColumns = @JoinColumn(name = "tutor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> assignedSubjects;

    public Tutor() {
    }
}
