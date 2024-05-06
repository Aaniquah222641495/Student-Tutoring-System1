package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name="TUTOR")
public class Tutor extends User{

    @OneToMany (mappedBy = "tutor")
    private Set<Student_Tutor_Subject> enrollments;
}
