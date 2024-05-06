package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name="STUDENT")
public class Student extends User{

    @OneToMany(mappedBy = "student")
    private Set<Student_Tutor_Subject> enrollments;
}
