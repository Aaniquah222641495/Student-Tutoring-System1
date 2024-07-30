package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Entity
@Builder
@Getter
@EqualsAndHashCode
@Table(name = "SUBJECT")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String subjectCode;
    private String name;
    private byte[] subjectGuide;

    @OneToMany(mappedBy = "subject")
    private Set<StudentTutorSubject> enrollments;

    public Subject() {}

}
